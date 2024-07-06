<!--基本信息-->
<template>
  <div class="user-info">
    <user-avatar ref="avatar" :cUserAvatar="userinfo.avatar"></user-avatar>
    <el-form :model="userinfo" ref="ruleForm" label-width="80px" style="margin-top:40px">
      <el-form-item label="昵称：" prop="nickName">
        <el-input v-model="userinfo.nickName" style="width:300px"></el-input>
      </el-form-item>
      <el-form-item label="姓名：" prop="realName">
        <el-input v-model="userinfo.realName" style="width:300px"></el-input>
      </el-form-item>
      <el-form-item label="手机号：" prop="phone">
        <el-input v-model="userinfo.phone" style="width:300px"></el-input>
      </el-form-item>
      <el-form-item label="身份证：" prop="identityNum">
        <el-input v-model="userinfo.identityNum" style="width:300px"></el-input>
      </el-form-item>
      <el-form-item label="地址：" prop="address">
        <el-input v-model="userinfo.address" style="width:300px"></el-input>
      </el-form-item>
    </el-form>
    <el-button style="margin-left: 310px;" type="success" @click="updateInfo">修改</el-button>
  </div>
</template>

<script>
import { loginUpdateByUsername, loginSelectByUsername } from "../../../api/user";
import UserAvatar from "../../../components/UserAvatar.vue";
export default {
  components: { UserAvatar },
  data() {
    return {
      userinfo: {
        avatar: "",
        nickName: "",
        realName:"",
        phone: "",
        identityNum: "",
        address: "",
      },
    };
  },
  methods: {
    updateInfo() {
      if (this.userinfo.nickName == "") {
        alert("昵称不能为空");
        return;
      }
      if (this.userinfo.realName == "") {
        alert("真实姓名不能为空");
        return;
      }
      this.userinfo.avatar = this.$refs.avatar.cUserAvatar;
      loginUpdateByUsername({
        realName:this.userinfo.realName,
        nickName: this.userinfo.nickName,
        phone: this.userinfo.phone,
        identityNum: this.userinfo.identityNum,
        address: this.userinfo.address,
        avatar: this.userinfo.avatar,
      })
        .then((res) => {
          if (res.flag == true) {
            console.log('res',res)
            console.log('this.userinfo',this.userinfo)
            this.$store.commit("removeStorage");
            this.$store.commit("setToken", res.data);
            this.$store.commit(
              "updateLoginUserNickname",
              this.userinfo.nickName
            );
            this.$store.commit("updateLoginUserAvatar", this.userinfo.avatar);
            alert(res.message);
          } else {
            alert(res.data);
          }
        })
        .catch((err) => {
          alert(res.message);
        });
    },
  },
  created() {
    this.$store.commit("updateUserActiveIndex", "1-1");
    loginSelectByUsername({}).then((res) => {
      this.userinfo = res.data;
      if (res.data.avatar != "") {
        // this.fileList;
      }
    });
  },
};
</script>

<style lang="less" scoped>
.user-info {
  margin: 0px auto;
  width: 900px;
  float: left;
  padding-left: 20px;
  background: #fff;
  height: 100%;
  min-height: 600px;
}
</style>
