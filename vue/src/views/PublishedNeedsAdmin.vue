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
      type: "needs",
      describe: "需求",
    };
  },
  components: {
    PublishedMessage,
  },
  created() {
    this.$store.commit("updatePublishActiveIndex", "4-2");
  },
};
</script>

<style>
</style>
