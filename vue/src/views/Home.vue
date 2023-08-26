<template>
  <div class="home-content">
    <navigation-bar></navigation-bar>
    <router-view></router-view>
  </div>
</template>

<script>
import NavigationBar from "../components/NavigationBar.vue";
export default {
  name: "Home",
  data() {
    return {};
  },
  components: {
    NavigationBar,
  },
};
</script>

<style lang="less" scoped> 
.home-content{
  width: 100%;
  height: 100%;
  overflow-x: hidden;
}
</style>