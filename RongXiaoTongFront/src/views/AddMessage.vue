<template>
  <div style="height:100%">
    <publish-nav></publish-nav>
  </div>
</template>

<script>
import PublishNav from "../components/PublishNav.vue";

export default {
  components: { PublishNav },
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
