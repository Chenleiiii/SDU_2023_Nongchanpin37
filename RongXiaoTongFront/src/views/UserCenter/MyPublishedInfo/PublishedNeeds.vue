<template>
  <div style="height:100%">
    <published-message :ctype="type" :cdesciibe="describe"></published-message>
  </div>
</template>

<script>
import PublishedMessage from "../../../components/PublishedMessage.vue";
export default {
  data() {
    return {
      type: "needs",
      describe: "需求",
    };
  },
  components: {
    PublishedMessage,
  },
  created() {
    this.$store.commit("updatePublishActiveIndex", "2-2");
  },
};
</script>

<style>
</style>
