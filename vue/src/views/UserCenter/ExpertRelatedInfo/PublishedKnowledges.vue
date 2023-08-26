<template>
  <div>
    <expert-published-knowledge></expert-published-knowledge>
  </div>
</template>

<script>
import ExpertPublishedKnowledge from "../../../components/ExpertPublishedKnowledge.vue";
export default {
  components: { ExpertPublishedKnowledge },
  data() {
    return {};
  },
  created() {
    this.$store.commit("updateUserActiveIndex", "2-3");
  },
};
</script>

<style>
</style>
