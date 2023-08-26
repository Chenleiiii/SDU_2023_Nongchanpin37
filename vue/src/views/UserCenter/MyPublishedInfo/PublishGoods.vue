<template>
  <div class="publish-goods-container">
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
      type: "goods",
    };
  },
  components: { PublishMessage },
  created() {
    this.$store.commit("updatePublishActiveIndex", "1");
  },
};
</script>

<style lang="less" scoped>
.publish-goods-container{
  min-height: 100%;
  width: 1100px;
  margin: 0 auto;
  background: #fff;
}
</style>
