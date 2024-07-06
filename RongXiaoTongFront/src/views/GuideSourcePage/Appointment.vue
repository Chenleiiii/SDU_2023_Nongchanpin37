<template>
  <div class="appointment-container">
    <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="150px" class="demo-ruleForm">
      <el-form-item label="地址" prop="address">
        <el-input v-model="ruleForm.address" placeholder="请输入地址"></el-input>
      </el-form-item>
      <el-form-item label="种植作物" prop="plantName">
        <el-input v-model="ruleForm.plantName" placeholder="请输入种植的作物"></el-input>
      </el-form-item>
      <el-form-item label="作物详细信息" prop="plantDetail">
        <el-input v-model="ruleForm.plantDetail" placeholder="请输入作物详细信息"></el-input>
      </el-form-item>
      <el-form-item label="作物条件" prop="plantCondition">
        <el-input v-model="ruleForm.plantCondition" placeholder="请输入作物生长状况"></el-input>
      </el-form-item>
      <el-form-item label="土壤条件" prop="soilCondition">
        <el-input v-model="ruleForm.soilCondition" placeholder="请输入土壤状况"></el-input>
      </el-form-item>
      <el-form-item label="面积" prop="area">
        <el-input v-model="ruleForm.area" placeholder="请输入面积"></el-input>
      </el-form-item>
      <el-form-item label="电话" prop="phone">
        <el-input v-model="ruleForm.phone" placeholder="请输入电话"></el-input>
      </el-form-item>

      <el-form-item style="float:right;">
        <el-button type="success" plain round @click="onSubmit">去预约</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import { addReserve } from '../../api/order'

export default {
  data(){
    return{
      ruleForm:{
        phone:'',
        soilCondition:'',
        plantCondition:'',
        plantDetail:'',
        plantName:'',
        address:'',
        area:'',
        status:0,
        expertName:this.$route.query.id,
      },
      rules:{

        phone: [{ required: true, message: '请输入电话', trigger: 'blur' }],
        soilCondition: [{ required: true, message: '请输入土壤状况', trigger: 'blur' }],
        plantCondition: [{ required: true, message: '请输入作物生长状况', trigger: 'blur' }],
        plantDetail: [{ required: true, message: '请输入作物详细信息', trigger: 'blur' }],
        plantName: [{ required: true, message: '请输入种植的作物', trigger: 'blur' }],
        address: [{ required: true, message: '请输入地址', trigger: 'blur' }],
        area: [{ required: true, message: '请输入面积', trigger: 'blur' }],
      }
    }
  },
  methods:{
    onSubmit(){
      if(localStorage.getItem('token')){
        this.$refs.ruleForm.validate((valid) => {
          if(valid){
            addReserve(this.ruleForm).then(res => {
              this.$message.success('预约成功！')
              this.$router.push("/home/guide").catch((err) => err);
            }).catch(err=>{
              console.log(err)
            })
          }else{
            console.log('error submit!!');
            return false;
          }
        });
      }else{
        this.$message.error('请先登录')
      }
    }
  },
  mounted(){
    this.$store.commit("updateActiveIndex", "5");
  }
}
</script>

<style lang="less" scoped>
.appointment-container{
  width: 1100px;
  height: 100%;
  background: #fff;
  margin: 30px auto;
  padding: 10px 20px;
}
</style>
