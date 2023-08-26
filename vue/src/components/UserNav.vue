<template>
  <div>
    <el-row class="tac user-nav">
      <el-col :span="12">
        <el-menu
          :default-active="this.$store.state.userActiveIndex"
          :active-text-color="'#67C23A'"
          class="el-menu-vertical-demo"
        >
          <el-submenu index="1">
            <template slot="title">
              <i class="el-icon-user-solid"></i>
              <span>我的信息</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="1-1" @click="UserInfoClick">
                <i class="el-icon-info"></i>
                基本信息
              </el-menu-item>
              <el-menu-item
                index="1-4"
                v-if="$store.getters.isExpert"
                @click="handleExperInfo"
              >
                <i class="el-icon-info"></i>
                专家信息
              </el-menu-item>
              <el-menu-item
                index="1-2"
                @click="UserAddressClick"
                v-if="!$store.getters.isExpert && !$store.getters.isAdmin"
              >
                <i class="el-icon-s-home"></i>
                收货地址
              </el-menu-item>
              <el-menu-item index="1-3" @click="UserPasswordClick">
                <i class="el-icon-s-tools"></i>
                修改密码
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu
            index="2"
            v-if="!$store.getters.isExpert && !$store.getters.isAdmin"
          >
            <template slot="title">
              <i class="el-icon-s-claim"></i>
              <span>我的发布</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="2-1" @click="PublishedGoodsClick">
                <i class="el-icon-s-shop"></i>
                我的商品
              </el-menu-item>
              <el-menu-item index="2-2" @click="PublishedNeedsClick">
                <i class="el-icon-s-comment"></i>
                我的需求
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu index="4" v-if="!$store.getters.isAdmin">
            <template slot="title">
              <i class="el-icon-s-order"></i>
              <span>专家管理</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="4-1" @click="handleExpertQuestion">
                <i class="el-icon-question"></i>
                我的问答
              </el-menu-item>
              <el-menu-item index="4-2" @click="handleExpertAppoint">
                <i class="el-icon-alarm-clock"></i>
                我的预约
              </el-menu-item>
              <!-- 只有专家有该模块权限 -->
              <el-menu-item
                index="4-3"
                v-if="$store.getters.isExpert"
                @click="PublishedKnowledgesClick"
              >
                <i class="el-icon-reading"></i>
                我的知识
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-submenu
            index="3"
            v-if="!$store.getters.isExpert && !$store.getters.isAdmin"
          >
            <template slot="title">
              <i class="el-icon-s-order"></i>
              <span>我的订单</span>
            </template>
            <el-menu-item-group>
              <el-menu-item index="3-1" @click="UserBuyClick">
                <i class="el-icon-s-goods"></i>
                我买的
              </el-menu-item>
              <el-menu-item index="3-2" @click="UserSellClick">
                <i class="el-icon-goods"></i>
                我卖的
              </el-menu-item>
            </el-menu-item-group>
          </el-submenu>
          <el-menu-item
            index="3"
            v-if="!$store.getters.isExpert && !$store.getters.isAdmin"
            @click="UserFinance"
          >
            <template slot="title">
              <i class="el-icon-postcard"></i>
              <span>我的融资</span>
            </template>
            
          </el-menu-item>

          <el-menu-item
            index="5"
            v-if="$store.getters.isAdmin"
            @click="UserManageClick"
          >
            <i class="el-icon-s-check"></i>
            <span slot="title">用户管理</span>
          </el-menu-item>
        </el-menu>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {
      // activeIndex: "1-1",
    };
  },
  methods: {
    UserFinance(){ 
      this.$router.push("/home/user/userfinance").catch((err) => err);
    },
    UserInfoClick() {
      this.$router.push("/home/user/userinfo").catch((err) => err);
    },
    UserAddressClick() {
      this.$router.push("/home/user/useraddress").catch((err) => err);
    },
    UserPasswordClick() {
      this.$router.push("/home/user/userpassword").catch((err) => err);
    },
    PublishedGoodsClick() {
      this.$router.push("/home/user/publishedgoods").catch((err) => err);
    },
    PublishedNeedsClick() {
      this.$router.push("/home/user/publishedneeds").catch((err) => err);
    },
    PublishedGoodsAdminClick() {
      this.$router.push("/home/user/publishedgoodsAdmin").catch((err) => err);
    },
    PublishedNeedsAdminClick() {
      this.$router.push("/home/user/publishedneedsAdmin").catch((err) => err);
    },
    PublishedKnowledgesClick() {
      this.$router.push("/home/user/publishedknowledges").catch((err) => err);
    },
    UserBuyClick() {
      this.$router.push("/home/user/userbuy").catch((err) => err);
    },
    UserSellClick() {
      this.$router.push("/home/user/usersell").catch((err) => err);
    },
    UserManageClick() {
      this.$router.push("/home/usermanage").catch((err) => err);
    },
    handleExpertQuestion() {
      this.$router.push("/home/user/expertQuestion").catch((err) => err);
    },
    handleExpertAppoint() {
      this.$router.push("/home/user/expertAppoint").catch((err) => err);
    },
    handleExperInfo() {
      this.$router.push("/home/user/expertInfo").catch((err) => err);
    },
  },
  created() {
    this.$store.commit("updateUserActiveIndex", "1-1");
  },
};
</script>

<style lang="less" scoped>
.user-content {
  width: 1100px;
  margin: 10px auto;
  // height: 100%;
  // background: #fff;
  .user-nav {
    float: left;
    width: 200px;
    margin-right: 20px;
    .el-col {
      width: 200px;
    }
  }
}
</style>