<template>
  <div class="publish-needs-container">
    <keep-alive>
      <publish-message :ctype="type"></publish-message>
    </keep-alive>
  </div>
</template>

<script>
import PublishMessage from "../../../components/PublishMessage.vue";
export default {
  data() {
    return {
      type: "needs",
    };
  },
  components: { PublishMessage },
  created() {
    this.$store.commit("updatePublishActiveIndex", "2");
  },
};
</script>

<style lang="less" scoped>
.publish-needs-container{
  min-height: 100%;
  width: 1100px;
  margin: 0 auto;
  background: #fff;
}
</style>
