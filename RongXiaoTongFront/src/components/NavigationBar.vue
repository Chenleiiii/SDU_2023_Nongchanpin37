<template>
  <div class="navigation-bar">
    <span class="initiator">
      <div class="logo-content">
        <div style="display:flex;flex-direction:row;justify-content:flex-start;align-items:center;height: 90px">
          <span class="logo-text" style="color: #4ab344;display: inline-block;margin-left: -1px">农产品</span>
          <span class="logo-text" style="color: #9e9d9d;display: inline-block;margin-left: -1px">融销一体平台</span>
          <img src="../assets/img/logo.png" style="height:60px;margin-left: 500px" alt="" />
          <span class="logo-text" style="color: #4ab344;display: inline-block;">融销通</span>
        </div>
      </div>

    </span>

    <div class="menu-content" v-cloak>
      <el-menu
        :default-active="$store.state.activeIndex"
        mode="horizontal"
        @select="handleSelect"
        background-color="#4ab344"
        text-color="#fff"
        active-text-color="#fff"
        id="menu">
        <el-menu-item index="1" class="item" @click="frontBtn">首页</el-menu-item>
        <el-menu-item index="2" class="item" @click="goodsBtn">商品货源</el-menu-item>
        <el-menu-item index="3" class="item" @click="purchaseBtn">求购需求</el-menu-item>
        <el-menu-item index="4" class="item" @click="knowledgesBtn">农业知识</el-menu-item>
        <el-menu-item index="5" class="item" @click="guideBtn">专家指导</el-menu-item>
        <el-menu-item index="6" class="item" @click="shopCartBtn">购物车</el-menu-item>
        <el-submenu index="7">
          <template slot="title">融资申请</template>
          <el-menu-item index="7-1" @click.native="smartMatchBtn">智能匹配</el-menu-item>
          <el-menu-item index="7-2" @click.native="financingBtn">融资申请</el-menu-item>
        </el-submenu>
        <div class="userin" v-if="$store.state.loginUserNickname == ''">
            <span @click="Login" class="login">登录</span> |
            <span @click="Register" class="register">注册</span>
        </div>
        <el-submenu index="8" v-else>
          <template slot="title">设置</template>
          <el-menu-item index="8-1" @click.native="userPage">个人中心</el-menu-item>
          <el-menu-item index="8-3" @click="userManage" v-if="$store.getters.isAdmin">用户管理</el-menu-item>
          <el-menu-item index="8-4" @click.native="goodsManage" v-if="$store.getters.isAdmin">商品管理</el-menu-item>
          <el-menu-item index="8-6" @click.native="logout">退出</el-menu-item>
        </el-submenu>
      </el-menu>
    </div>
  </div>
</template>

<script>
let Base64 = require("js-base64");
export default {
  data() {
    return {
      avatar: "",
    };
  },
  methods: {
    handleSelect(key, keyPath) {},
    Login() {
      this.$router.push("/login");
    },
    Register() {
      this.$router.push("/register");
    },
    logout() {
      this.$store.commit("updateLoginUserNickname", "");
      this.$store.commit("removeStorage");
      this.$router.push("/home").catch((err) => err);
      if (sessionStorage.getItem("/order/needs/pageCode")) {
        sessionStorage.removeItem("/order/needs/pageCode");
      }
      if (sessionStorage.getItem("/order/goods/pageCode")) {
        sessionStorage.removeItem("/order/goods/pageCode");
      }
      if (sessionStorage.getItem("/user/search/pageCode")) {
        sessionStorage.removeItem("/user/search/pageCode");
      }
    },
    frontBtn() {
      this.$router.push("/home/front").catch((err) => err);
    },
    purchaseBtn() {
      this.$router.push("/home/purchase").catch((err) => err);
    },
    goodsBtn() {
      this.$router.push("/home/goods").catch((err) => err);
    },
    knowledgesBtn() {
      this.$router.push("/home/knowledge").catch((err) => err);
    },
    guideBtn() {
      this.$router.push("/home/guide").catch((err) => err);
    },
    shopCartBtn() {
      this.$router.push("/home/shopcart").catch((err) => err);
    },
    userPage() {
      this.$router.push("/home/user").catch((err) => err);
    },
    addMessagePage() {
      this.$router.push("/home/addmessage").catch((err) => err);
    },
    handleAbout() {
      this.$router.push("/home/aboutUs").catch((err) => err);
    },
    goodsManage(){
      this.$router.push("/home/userGood/publishedgoodsAdmin").catch((err) => err)
    },
    userManage(){
      this.$router.push("/home/usermanage").catch((err) => err);
    },
    financingBtn() {
      this.$router.push("/home/financing").catch((err) => err);
    },
    smartMatchBtn() {
      this.$router.push("/home/smartMatch").catch((err) => err);
    },
  },
  created() {
    this.$store.commit("updateActiveIndex", "1");
    if (window.localStorage.token) {
      let token = window.localStorage.token;
      let arr = token.split(".");
      let res = Base64.decode(arr[1]);
      this.$store.commit("updateLoginUserNickname", JSON.parse(res).nickname);
      this.$store.commit("updateLoginUserAvatar", JSON.parse(res).avatar);
      this.$store.commit("updateRole", JSON.parse(res).role);
    }
    console.log(this.$store.state.loginUserNickname)
  },
};
</script>

<style lang="less" scoped>
.navigation-bar {
  width: 100%;
  height: 160px;
  .initiator{
    width: 1100px;
    margin: 0 auto;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
    color: #035D1C;
    padding: 5px 20px;
    .logo-content{
      color: #035D1C;
      text-align: center;
      .logo-text{
        margin-left: 10px;
        font-size: 36px;
        font-family: 微软雅黑;
        font-weight: bold;
        display: flex;
        flex-direction: column;
        align-items: flex-start;
        // justify-content: flex-start;
      }
    }
  }
  .menu-content{
    height: 60px;
    background-color: #4ab344 !important;
  }
  .el-menu {
    width: 1100px;
    margin: 0 auto;
    height: 60px;
    .el-menu-item {
      background-color: #4ab344 !important;
      height: 60px;
      line-height: 60px;
      font-size: 16px;
      width: 110px;
      text-align: center;
    }
    .el-submenu {
      .template {
        background-color: #4ab344 !important;
        height: 60px;
        line-height: 60px;
        font-size: 16px;
      }
      .el-submenu__title {
        font-size: 16px !important;
        line-height: 60px;
        height: 60px;
        background-color: #4ab344;
      }
      .el-menu-item {
        background-color: #4ab344 !important;
        height: 60px;
        line-height: 60px;
        font-size: 16px;
      }
      background-color: #4ab344 !important;
      height: 60px;
      line-height: 60px;
      font-size: 16px !important ;
    }
  }
  .login{
    cursor: pointer;
  }
  .register{
    cursor: pointer;
  }
}
.el-menu.el-menu--horizontal{
  border-bottom: none;
}
.el-menu--horizontal>.el-menu-item.is-active{
  background-color: white !important;
}

.menu-content /deep/ .el-submenu__title i{
  color: #4ab344;
}

[v-cloak] {
  display: none;
}

.el-menu-item.is-active {
  color:#4ab344!important;
}

.el-submenu__title:focus,
.el-submenu__title:hover {
  outline: 0;
  background-color: white !important;
  color: #4ab344 !important;
}

.el-menu-item:focus,
.el-menu-item:hover {
  outline: 0;
  background-color: white !important;
  color: #4ab344 !important;
}

.userin  {
  font-size: 16px;
  height: 60px;
  text-align: center;
  color: #ffffff;
  line-height: 60px;
}

.menu-content[data-v-d1a7e442] .el-submenu__title i {
  color: #e24f4f;
}
::v-deep .el-menu--horizontal > .el-submenu .el-submenu__title

{
  height: 60px;
  line-height: 60px;
  font-size: 16px;
  &:hover{
    background-color: white !important;
    color: #4ab344 !important;
  }
}

.el-menu--horizontal > .el-menu-item:hover {
  background-color: white !important;
  color: #4ab344 !important;
}
</style>
