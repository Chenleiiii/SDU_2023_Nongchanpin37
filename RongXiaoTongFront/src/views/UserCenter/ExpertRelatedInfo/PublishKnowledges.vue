<template>
  <div>
    <keep-alive>
      <expert-publish-knowledge :ctype="type"></expert-publish-knowledge>
    </keep-alive>
  </div>
</template>

<script>
import ExpertPublishKnowledge from "../../../components/ExpertPublishKnowledge.vue";
export default {
  data() {
    return {
      type: "knowledges",
    };
  },
  components: { ExpertPublishKnowledge },
  created() {
    this.$store.commit("updatePublishActiveIndex", "3");
  },
};
</script>

<style>
</style>
