<template>
  <div class="receiving-address">
    <div class="title">我的收货地址</div>
    <div class="default-address-container">
      <div>
        <div class="address-item">收货人：{{addressData.consignee}}</div>
        <div class="address-item">收货地址：{{addressData.addressDetail}}</div>
        <div class="address-item">收货手机号：{{addressData.phone}}</div>
      </div>

      <el-button type="success" @click="handleChange">更换地址</el-button>
    </div>
    <el-dialog title="更换地址" :visible.sync="dialogVisible" width="580px" :before-close="handleClose">
      <el-table :data="allAddressData" tooltip-effect="dark" style="width: 100%"
       @select="handleSelectionChange" ref="listTable">
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
    <!-- <el-checkbox
      v-model="addressData.isDefault"
      @change="changeChecked"
      class="default-address">设为默认地址</el-checkbox>
    <el-button type="primary" class="update-info" @click="updateAddress">确认收货地址</el-button> -->
  </div>
</template>

<script>
import {
  defaultAddressInfoUpdate,
  selectDefaultByOwnName,
  selectAllAddressByUsername
} from "../api/address";
export default {
  data() {
    return {
      addressData: [],
      allAddressData:[],
      dialogVisible:false
    };
  },
  methods: {
    changeChecked(e) {
      console.log(e);
      this.addressData.isDefault = e;
    },

    getAllAdress(){
      selectAllAddressByUsername().then(res=>{
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
      //只能选择一行，选择其他，清除上一行
      if(row.length > 1){
        let del_row = row.shift()
        this.$refs.listTable.toggleRowSelection(del_row,false) //设置这一行取消选中
        this.addressData = Object.assign({},{...row[0]})
      }else{
        this.addressData = Object.assign({},{...row[0]})
      }
    }
  },
  created() {
    this.getAllAdress()
    selectDefaultByOwnName({})
      .then((res) => {
        this.addressData = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>

<style lang="less" scoped>
.receiving-address {
  position: relative;
  .title {
    border-bottom: 2px solid #f2f2f2;
    padding: 10px 0px;
    font-size: 18px;
  }
}
.default-address-container{
  border: 1px dashed darkseagreen;
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
}
</style>
