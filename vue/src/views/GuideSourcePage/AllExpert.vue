<template>
  <div>
    <Subtitle subtitle="专家列表" description="欢迎咨询专业人士 ~"  style="margin-top:100px;"/>

    <div class="allExpert-page">
      <expert-source :cgoods="goods" @handleSearch="handleSearch"></expert-source>
      <pagination @item-click="pageClick" :cUrl="url" :cTotal="total" :cPageSize="pageSize"></pagination>
    </div>
  </div>
</template>
<script>
import { selectExpert } from "../../api/order";
import ExpertSource from "../../components/ExpertSource.vue";
import Pagination from "../../components/Pagination.vue";
import Subtitle from "../../components/Subtitle";
export default {
  data() {
    return {
      goods: [],
      total: 0,
      pageSize: 30,
      searchValue:'',
      url: "/order/goods/",
      goodsCount: sessionStorage.getItem("/order/goods/pageCode")
        ? sessionStorage.getItem("/order/goods/pageCode")
        : 1,
    };
  },
  mounted() {
    this.$store.commit("updateActiveIndex", "5");
    this.getData()
  },
  methods: {
    pageClick(item) {
      this.goods = item;
    },
    handleSearch(val){
      this.searchValue = val
      this.getData()
    },
    getData(){
      selectExpert({
        pageNum: this.goodsCount,
        keys:this.searchValue
      }).then((res) => {
        // console.log('ressss--',res,res.data,res.data.lis)
        if (res.flag == true) {
          this.goods = res.data.list;
          this.total = res.data.total;
        } else {
          // alert(res.data.data);
        }
      });
    }
  },
  components: {
    Pagination,
    ExpertSource,
    Subtitle
  },
};
</script>

<style lang="less" scoped>
.allExpert-page {
  width: 100%;
  margin: 0 auto;

  // float: left;
}
</style>
