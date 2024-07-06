<template>
  <div class="question-container">
    <el-form ref="form" :model="form" :rules="ruleForm" label-width="150px">
      <el-form-item label="标题：" prop="title">
        <el-input v-model="form.title"></el-input>
      </el-form-item>
      <el-form-item label="内容：" prop="question">
        <el-input type="textarea" v-model="form.question"></el-input>
      </el-form-item>
      <el-form-item label="农作物名称：" prop="plantName">
        <el-input type="textarea" v-model="form.plantName"></el-input>
      </el-form-item>
      <el-form-item label="手机号：" prop="phone">
        <el-input type="text" v-model="form.phone"></el-input>
      </el-form-item>
      <el-form-item style="float:right;">
        <el-button type="success" @click="onSubmit">去提问</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import { addQuestion } from "../../api/order";

export default {
  data(){
    return{
      form:{
        title:'',
        plantName:'',
        phone:'',
        expertName:this.$route.query.id,
        status:0,
        question:''
      },
      ruleForm:{
        title: [{ required: true, message: '请输入标题', trigger: 'blur' }],
        plantName: [{ required: true, message: '请输入农作物名称', trigger: 'blur' }],
        phone: [{ required: true, message: '请输入手机号', trigger: 'blur' }],
        question: [{ required: true, message: '请输入内容', trigger: 'blur' }],
      }
    }
  },
  methods:{
    onSubmit(){
      if(localStorage.getItem('token')){
        this.$refs.form.validate((valid) => {
          if(valid){
            addQuestion(this.form).then(res=>{
              this.$message.success('提问成功！')
              this.$router.push("/home/guide").catch((err) => err);
            }).catch(err=>{
              console.log(err)
            })
          }else{
            console.log('error submit!!');
            return false;
          }
        } )
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
.question-container{
  width: 1100px;
  height: 100%;
  margin: 10px auto;
  background: #fff;
  padding: 20px;
}
</style>
