<template>
  <div>

    <div class="font-background">
      <div class="font">
        <div style="writing-mode: vertical-rl;color: #FCFCFC;font:17px 'SF Pro SC';">PRODUCTION</div>
        <div style="writing-mode: vertical-rl;color: #FCFCFC;font:23px 宋体;margin-left: 36px;margin-top:18px">健康养殖</div>
        <div style="writing-mode: vertical-rl;color: #FCFCFC;font:23px 宋体;margin-left: 12px;margin-top:18px">品质精选</div>
      </div>
    </div>


    <Subtitle subtitle="知识列表" description="买到就是赚到哦~"  style="margin-top:100px;"/>
    <div class="home-konwledges">
      <knowledge :cknowledges="knowledges"></knowledge>
      <pagination
          @item-click="pageClick"
          :cUrl="url"
          :cTotal="total"
          :cPageSize="pageSize"
      ></pagination>
    </div>

  </div>
</template>

<script>
import { selectKnowledgesPage } from "../../api/knowledge";
import Knowledge from "./Knowledge.vue";
import Pagination from "../../components/Pagination.vue";
import Subtitle from "../../components/Subtitle";
export default {
  data() {
    return {
      knowledges: [],
      total: 0,
      pageSize: 10,
      url: "/knowledge/",
      knowledgesCount: sessionStorage.getItem("/knowledge/pageCode")
        ? sessionStorage.getItem("/knowledge/pageCode")
        : 1,
    };
  },
  created() {
    this.$store.commit("updateActiveIndex", "4");
    selectKnowledgesPage({
      pageNum: this.knowledgesCount,
    }).then((res) => {
      if (res.flag == true) {
        let tmp = res.data.list;
        tmp.forEach(e => {
          const flieArr = e.picPath.split('.');
          e.type = flieArr[flieArr.length - 1]
        })
        this.knowledges = tmp;
        this.total = res.data.total;
      }
    });
  },
  methods: {
    pageClick(item) {
      this.knowledges = item;
    },
  },
  components: {
    Knowledge,
    Pagination,
    Subtitle
  },
};
</script>

<style lang="less" scoped>

.font-background{
  background-image: url("../../assets/page4/background4.jpg");
  height: 400px;
  width: 1920px;
  padding-left: 650px;
  padding-top: 60px;
  .font{
    background-image: url('../../assets/page4/fontback4.png');
    background-size: 290px;
    background-repeat: no-repeat;
    height: 290px;
    padding-top: 175px;
    padding-left: 150px;
    display: flex;
  }
}
</style>
