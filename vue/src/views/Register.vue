<template>
  <div class="login">
    <div class="big-title">
      <div style="width:500px;font:120px 字魂武林江湖体;color:#ffaa00;margin-left: 240px">融销通</div>
      <div class="title" style="font-family:字魂27号-布丁体;" >
        农产品融销一体化平台
      </div>


    </div>
    <div style="margin-top: 10px" class="registerPart">
      <img :src="require(`@/assets/img/yellowlogo.png`)" id="icon" >
      <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <h2>用户注册</h2>
        <el-form-item label="账号" prop="username">
          <el-input placeholder="请输入账号"  v-model="ruleForm.username" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="昵称" prop="nickname">
          <el-input placeholder="请输入昵称"  v-model="ruleForm.nickname" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input placeholder="请输入密码"  type="password" v-model="ruleForm.password" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="确认密码" prop="checkPass">
          <el-input placeholder="请再次输入密码"  type="password" v-model="ruleForm.checkPass" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
          <el-button round type="warning" @click="register('ruleForm')">注册</el-button>
          <el-button round @click="resetForm('ruleForm')">重置</el-button>
        </el-form-item>
        <div style="text-align: right;">
          <el-link type="warning" style="margin-top: 20px;font-weight: 100" @click="$router.push('/login');">已有账号？去登录</el-link>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script >
import {userLogin, userRegister} from "../api/user";

export default {
  name: 'HomeView',

  data() {
    var validateUsername = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入用户名'));
      } else {
        callback();
      }
    };
    var validateNickname = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入昵称'));
      } else {
        callback();
      }
    };
    var validatePass = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请输入密码'));
      } else {
        if (this.ruleForm.checkPass !== '') {
          this.$refs.ruleForm.validateField('checkPass');
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === '') {
        callback(new Error('请再次输入密码'));
      } else if (value !== this.ruleForm.password) {
        callback(new Error('两次输入密码不一致!'));
      } else {
        callback();
      }
    };
    return {
      ruleForm: {
        username:'',
        password: '',
        checkPass: '',
        nickname:'',
      },
      rules: {
        password: [
          { validator: validatePass, trigger: 'blur' }
        ],
        checkPass: [
          { validator: validatePass2, trigger: 'blur' }
        ],
        username:[
          { validator: validateUsername, trigger: 'blur' }
        ],
        nickname:[
          { validator: validateNickname, trigger: 'blur' }
        ]
      }
    };
  },



  methods:{
    resetForm(formName) {
      this.$refs[formName].resetFields();
    },
    register(formName){
      this.$refs[formName].validate((valid) => {
        if (valid) {
          console.log(this.ruleForm.username)
          userRegister({
            userName: this.ruleForm.username,
            password: this.ruleForm.password,
            nickName: this.ruleForm.nickname,
            avatar: "rongxiaotong.gif",
          })
              .then((res) => {
                if (res.flag == true) {
                  alert(res.message);
                  this.$store.commit("updateLoginUserNickname", this.nickName);
                  this.$router.push("/login").catch((err) => err);
                } else {
                  alert(res.data);
                }
              })
              .catch((err) => {
                alert(err);
              });
        } else {
          console.log('error submit!!');
          return false;
        }
      });

    }
  }
}




</script>
<style lang="less" scoped>
#icon{
  position:absolute;
  width: 100px;
  top:0%;
  left:50%;
  transform:translate(-50%,-50%);
}

.login {
  box-sizing: border-box;
  height: 100%;
  padding-top: 150px;
  background: url("../assets/img/Login.jpg");
  background-size: 1707px 837px;

  .big-title {
    width: 900px;
    margin-top: 120px;

    .title {
      padding-top: 27px;
      padding-left: 35px;
      height: 94px;
      background: url('../assets/img/fontback.png');
      background-size: 470px;
      background-repeat: no-repeat;
      margin-left: 220px;
      font-size: 35px;
      color: #ff9f34
    }
  }
}


.registerPart{
  position:absolute;
  /*定位方式绝对定位absolute*/
  top:50%;
  left:80%;
  /*!*顶和高同时设置50%实现的是同时水平垂直居中效果*!*/
  transform:translate(-50%,-50%);
  /*实现块元素百分比下居中*/
  width:450px;
  min-height: 300px;
  padding-top:70px;
  padding-bottom:15px;
  padding-right:50px;

  background: rgba(0,0,0, .6);
  /*背景颜色为黑色，透明度为0.8*/
  box-sizing:border-box;
  /*box-sizing设置盒子模型的解析模式为怪异盒模型，
  将border和padding划归到width范围内*/
  box-shadow: 0px 15px 25px rgba(0,0,0,.5);
  /*边框阴影  水平阴影0 垂直阴影15px 模糊25px 颜色黑色透明度0.5*/
  border-radius:15px;
  /*边框圆角，四个角均为15px*/
}
.registerPart h2{
  margin-top: -10px;
  margin-bottom: 20px;
  padding:0;
  color: #fff;
  font-weight: bold;
  font-size: 22px;
  font-family: "PingFang SC";
  /*文字居中*/
  margin-left:45.5%
}
.registerPart .inputbox{
  position:relative;
}
.registerPart .inputElement .el-input__wrapper{
  width: 100%;
  padding:5px 0;
  font-size:14px;
  color:white;
  letter-spacing: 1px;
  /*字符间的间距1px*/
  /*margin-bottom: 30px;*/
  border:none;
  border-bottom: 1px solid #fff;
  box-shadow: none;
  outline:none;
  /*outline用于绘制元素周围的线在这里用途,是将输入框的边框的线条使其消失*/

}

::v-deep .el-input__inner{
  background-color: rgba(0, 0, 0, 0);
  border: 1px solid #dba155;
  color: #ffffff;
  font-weight: 100;
  font-size: 16px;
  &::placeholder{
    color: #848484;
  }
}

::v-deep .el-form-item__label{
  color: #dba155;
  font-family: 黑体;
  font-size: 17px;
  font-weight: bold;
}

.el-button{
  background-color: rgba(255, 255, 255,0.2);
  color: #dba155;
  font-weight: 600;
  font-size: 17px;
  border: 1px solid #dba155;
  width: 48%;
}

.el-button:hover {
  color: #ffc377;
  background-color: rgba(255, 255, 255,0.5);
  border: 1px solid #dba155;
}



</style>
