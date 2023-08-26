<template>
  <div class="pagination">
    <el-pagination
      background
      layout="prev, pager, next"
      :page-size="this.cPageSize"
      :total="this.cTotal"
      :current-page.sync="pageCode"
      @current-change="currentChange"
      v-if="this.cTotal != 0">
    </el-pagination>
  </div>
</template>

<script>
import { pagination } from "../api/pagination";
export default {
  data() {
    return {
      pageGoods: [],
      // pageSize: 6,
      pageCode: parseInt(sessionStorage.getItem(this.cUrl + "pageCode"))
        ? parseInt(sessionStorage.getItem(this.cUrl + "pageCode"))
        : 1,
    };
  },
  props: {
    cUrl: {
      type: String,
    },
    cTotal: {
      type: Number,
    },
    cPageSize: {
      type: Number,
    },
  },
  methods: {
    currentChange(current) {
      sessionStorage.setItem(this.cUrl + "pageCode", current);
      pagination({
        cUrl: this.cUrl,
        pageNum: this.pageCode,
      }).then((res) => {
        if (res.flag == true) {
          this.pageGoods = res.data.list;
          this.$emit("item-click", this.pageGoods);
        }
      });
    },
  },
};
</script>

<style lang="less" scoped>
.pagination {
  box-sizing: border-box;
  padding-left: 600px;
  width: 1500px;
  margin-top: 50px;
  // position: absolute;
  // left: 50%;
  // transform: translateX(-50%);
  bottom: 50px;
  .el-pagination {
    width: 40px;
    height: 40px;
  }
}
</style>