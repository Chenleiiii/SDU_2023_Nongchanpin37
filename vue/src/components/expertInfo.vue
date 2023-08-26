<template>
  <div class="expert-info-container">
    <el-form label-width="80px" :model="form">
      <el-form-item label="真实姓名">
        <el-input v-model="form.realName" style="width:290px;"></el-input>
      </el-form-item>
      <el-form-item label="手机号">
        <el-input v-model="form.phone" style="width:290px;"></el-input>
      </el-form-item>
      <el-form-item label="从事专业">
        <el-input v-model="form.profession" style="width:290px;"></el-input>
      </el-form-item>
      <el-form-item label="职位">
        <el-input v-model="form.position" style="width:290px;"></el-input>
      </el-form-item>
      <el-form-item label="所属单位">
        <el-input v-model="form.belong" style="width:290px;"></el-input>
      </el-form-item>
    </el-form>
    <div style="text-align:center;margin-right:130px;">
      <el-button type="success" @click="addExpertInfo">修改</el-button>
    </div>
  </div>
</template>

<script>
import { getExpertInfo ,editExpertInfo} from '../api/expert.js'

export default {
  data(){
    return{
      form:{
        realName:'',
        phone:'',
        profession:'',
        position:'',
        belong:''
      }
    }
  },
  methods:{
    getExpertData(){
      getExpertInfo({}).then(res=>{
        this.form = Object.assign({},{...res.data})
      }).catch(err=>{
        console.log(err)
      })
    },
    addExpertInfo(){
      editExpertInfo(this.form).then(res => {
        console.log('edit',res)
        if(res.flag==true){
          this.$message.success('修改成功')
        }else{
          this.$message.error(res.message)
        }
      }).catch(err=>{
        console.log(err)
      })
    }
  },
  mounted(){
    this.getExpertData()
  }
}
</script>

<style lang="less" scoped>
.expert-info-container{
  width: 900px;
  height: 100%;
  background: #fff;
  padding: 10px 20px;
}
</style>