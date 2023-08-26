<template>
  <div class="add-address">
    <div class="title">我的收货地址</div>
    <el-button type="success" round plain style="margin-top:10px;" @click="handleAdd">添加</el-button>
    <div v-for="(item,index) in allAddressData" :key="index"  class="default-address-container">
      <div>
        <div class="address-item">收货人：{{item.consignee}}</div>
        <div class="address-item">收货地址：{{item.addressDetail}}</div>
        <div class="address-item">收货手机号：{{item.phone}}</div>
      </div>
      <div class="right-btn">
        <el-tag style="position:relative;top:-40px;right:-138px;margin-right: 20px;" v-if="item.isDefault" type="success">默认收货地址</el-tag>
        <!-- <div class="marginR20" @click="handleDetail(item)">详情</div>   -->
        <div class="marginR20" @click="handleEdit(item)">编辑</div>
        <div class="marginR20" @click="handleDel(item)">删除</div>
      </div>
    </div>
    <el-dialog title="更换地址" :visible.sync="dialogVisible" width="580px" :before-close="handleClose">
      <el-table ref="multipleTable" :data="allAddressData" tooltip-effect="dark" style="width: 100%"
       @select="handleSelectionChange">
        <el-table-column type="selection" width="55"></el-table-column>
        <el-table-column label="收货人" prop="consignee" width="120" show-overflow-tooltip></el-table-column>
        <el-table-column prop="addressDetail" label="收获地址" show-overflow-tooltip></el-table-column>
        <el-table-column prop="phone" label="收获手机号" width="120" show-overflow-tooltip></el-table-column>
      </el-table>

      <span slot="footer" class="dialog-footer">
        <el-button @click="handleClose">取 消</el-button>
        <el-button type="success" @click="submitChange">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog :title="title" :visible.sync="showAdd" width="580px" :before-close="closeAdd">
      <el-form :model="addressData" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="收货人：" prop="consignee">
          <el-input v-model="addressData.consignee"></el-input>
        </el-form-item>
        <el-form-item label="收货地址：" prop="addressDetail">
          <el-input v-model="addressData.addressDetail"></el-input>
        </el-form-item>
        <el-form-item label="收货手机号：" prop="phone">
          <el-input v-model="addressData.phone"></el-input>
        </el-form-item>
        <el-checkbox style="float:right;" v-model="addressData.isDefault">设为默认地址</el-checkbox>
      </el-form>

      <span slot="footer" class="dialog-footer">
        <el-button @click="closeAdd">取 消</el-button>
        <el-button type="success" @click="updateAddress">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>

<script>
import {
  defaultAddressInfoUpdate,
  selectDefaultByOwnName,
  addAddress,
  selectAllAddressByUsername,
  deleteAddressById
} from "../../../api/address";
export default {
  data() {
    return {
      addressData: {
        consignee:"",
        phone:'',
        addressDetail:'',
        isDefault:false
      },
      allAddressData:[],
      dialogVisible:false,
      showAdd: false,
      title:'添加地址'
    };
  },
  methods: {
    changeChecked(e) {
      console.log(e);
      this.addressData.isDefault = e;
    },
    getAllAdress(){
      selectAllAddressByUsername().then(res=>{
        console.log("data--------------")
        console.log('ressss',res)
        this.allAddressData = res.data

      }).catch(err=>{
        console.log(err)
      })
    },
    handleChange(){
      this.dialogVisible = true
    },
    submitChange(){
      this.dialogVisible = false
    },
    handleClose(){
      this.dialogVisible = false
    },
    handleSelectionChange(row, column){
      this.addressData = [...row]
    },
    handleAdd(){
      this.showAdd = true
      this.title = '添加地址'
    },
    closeAdd(){
      this.showAdd = false
      this.addressData = {}
    },
    updateAddress() {
      if (this.addressData.consignee == "") {
        alert("收货人不能为空");
        return;
      } else if (this.addressData.phone == "") {
        alert("手机号不能为空");
        return;
      } else if (this.addressData.addressDetail == "") {
        alert("收货地址不能为空");
        return;
      }
      if(this.title === '编辑地址'){
        defaultAddressInfoUpdate({
          id: this.addressData.id,
          consignee: this.addressData.consignee,
          phone: this.addressData.phone,
          addressDetail: this.addressData.addressDetail,
          isDefault: this.addressData.isDefault,
        }).then((res) => {
          if (res.flag == true) {
            this.getAllAdress()
            this.$message.success(res.message)
            this.showAdd = false
          } else {
            this.showAdd = false
            this.$message.error(res.data)
          }
        });
      }else{
        addAddress({
          consignee: this.addressData.consignee,
          phone: this.addressData.phone,
          addressDetail: this.addressData.addressDetail,
          isDefault: this.addressData.isDefault,
        }).then((res) => {
          if (res.flag == true) {
            this.getAllAdress()
            this.$message.success(res.message)
            this.showAdd = false
          } else {
            this.showAdd = false
            this.$message.error(res.data)
          }
        });
      }
    },
    handleDetail(item){

    },
    handleEdit(item){
      this.showAdd = true
      this.title = '编辑地址'
      this.addressData = Object.assign({},{...item})
    },
    handleDel(item){
      this.$confirm('确认删除该信息?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          // type: 'warning'
        }).then(() => {
          deleteAddressById({
            addressId:item.id
          }).then(res=>{
            if(res.flag == true){
              this.getAllAdress()
                this.$message({
                type: 'success',
                message: '删除成功!'
              });
            }else{
              this.$message({type: 'error',message: res.message});
            }
          }).catch(err=>{
            this.$message({
            type: 'error',
            message: '删除失败!'
          });
          })
        }).catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除'
          });
        });
    }
  },
  created() {
    this.getAllAdress()
    // selectDefaultByOwnName({})
    //   .then((res) => {
    //     this.addressData = res.data;
    //   })
    //   .catch((err) => {
    //     console.log(err);
    //   });
  },
};
</script>

<style lang="less" scoped>
.add-address {
  width: 900px;
  float: left;
  padding: 20px;
  background: #fff;
  min-height: 100%;
  .title {
    border-bottom: 1px solid #f2f2f2;
    padding: 10px 0px;
    font-size: 18px;
  }
}
.default-address-container{
  border: 1px dashed #ccc;
  border-radius: 6px;
  padding: 10px 20px;
  display: flex;
  margin-top: 20px;
  align-items: center;
  justify-content: space-between;
  .address-item{
    line-height: 30px;
    height: 30px;
    margin-right: 50px;
  }
  .right-btn{
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
    .marginR20{
      margin-right: 20px;
      cursor: pointer;
      color: #67C23A;
      &:hover{
        color: #035D1C;
        text-decoration: underline;
      }
    }
  }
}
</style>
