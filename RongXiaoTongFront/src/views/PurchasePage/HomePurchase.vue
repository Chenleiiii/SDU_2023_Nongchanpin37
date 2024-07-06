<template>
  <div>
    <div class="font-background">
      <img src="../../assets/page3/fontback3.png" alt="">
      <img src="../../assets/img/fontback.png" alt="" style="margin-top: 20px">
      <div style="margin-top:-65px;margin-left:35px;color: #4ab344;font: 24px 思源黑体heavy;">健康生态绿色种植好米好味道</div>
    </div>
    <Subtitle subtitle="需求列表" description="买到就是赚到哦~"  style="margin-top:100px;"/>
    <div class="home-purchase">
      <purchase :cneeds="needs" @handleSearch="handleSearch"></purchase>
      <pagination
          @item-click="pageClick"
          :cUrl="url"
          :cTotal="total"
          :cPageSize="pageSize"></pagination>
    </div>
  </div>

</template>

<script>
import { selectNeedsPage } from "../../api/order";
import Purchase from "./Purchase.vue";
import Pagination from "../../components/Pagination.vue";
import Subtitle from "../../components/Subtitle";
export default {
  data() {
    return {
      needs: [],
      total: 0,
      pageSize: 30,
      searchValue:"",
      url: "/order/needs/",
      needsCount: sessionStorage.getItem("/order/needs/pageCode")
        ? sessionStorage.getItem("/order/needs/pageCode")
        : 1,
    };
  },
  created() {
    this.$store.commit("updateActiveIndex", "3");
    this.getData()
  },
  methods: {
    getData(){
      selectNeedsPage({
        pageNum: this.needsCount,
        keys:this.searchValue
      }).then((res) => {
        if (res.flag == true) {
          this.needs = res.data.list;
          this.total = res.data.total;
        }
      });
    },
    pageClick(item) {
      this.needs = item;
    },
    handleSearch(val){
      this.searchValue = val
      this.getData()
    }
  },
  components: {
    Purchase,
    Pagination,
    Subtitle
  },
};
</script>

<style lang="less" scoped>
.home-purchase {
  width: 1500px;
  margin: 0 auto;
}

.font-background{
  background-image: url("../../assets/page3/background3.jpg");
  height: 400px;
  width: 1920px;
  padding-left: 350px;
  padding-right: 800px;
  padding-top: 90px;

}
</style>;
