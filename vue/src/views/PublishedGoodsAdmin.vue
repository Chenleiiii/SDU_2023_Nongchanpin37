<template>
  <div style="width:900px;height:100%">
    <published-message :ctype="type" :cdesciibe="describe"></published-message>
  </div>
</template>

<script>
import PublishedMessage from "../components/PublishedMessageAdmin.vue";
export default {
  data() {
    return {
      type: "goods",
      describe: "商品",
    };
  },
  components: { PublishedMessage },
  created() {
    this.$store.commit("updateUserActiveIndex", "4-1");
  },
};
</script>

<style>
</style>