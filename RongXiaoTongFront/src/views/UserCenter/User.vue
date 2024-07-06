<template>
  <div class="user-content">
    <user-nav></user-nav>
    <div class="right-content">
      <router-view></router-view>
    </div>
  </div>
</template>

<script>
import UserNav from "../../components/UserNav.vue";
export default {
  components: { UserNav },
  beforeRouteEnter(to, from, next) {
    let token = window.localStorage.token;
    if (token == null || token == "" || token == undefined) {
      next("/login");
    } else {
      next();
    }
  },
};
</script>

<style lang="less" scoped>
.user-content{
  width: 1100px;
  height: 100%;
  margin: 0 auto;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  .right-content{
    min-height: 100%;
    padding-top: 20px;

    height: auto;
    background: #fff;
    width: 100%;
  }
}
</style>
