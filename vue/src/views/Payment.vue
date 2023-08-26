<template>
  <div v-html="data" class="payment-box">{{ data }}</div>
</template>

<script>
export default {
  data() {
    return {
      data: "",
    };
  },
  mounted() {
    let form = this.$route.query.htmlData;
    this.data = form;
    this.$nextTick(() => {
      document.forms[0].submit();
    });
  },
};
</script>

<style lang="less" scoped>
.payment-nox {
  width: 1200px;
  height: 600px;
  margin: 0 auto;
}
</style>