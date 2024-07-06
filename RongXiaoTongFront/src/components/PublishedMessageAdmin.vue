<!--我的发布-->
<template>
  <div class="published-message">
    <el-button type="success" @click="publishClick" style="margin: 10px 20px"
      >发布{{ cdesciibe }}</el-button
    >
    <div class="search" style="text-align: center">
      <el-input
        v-model="searchValue"
        maxlength="100"
        placeholder="请输入商品内容进行搜索"
        clearable
        style="width: 290px"
      />
      <img
        src="../assets/img/search.png"
        @click="handleSearch"
        class="search-icon"
      />
    </div>
    <div
      style="
        display: flex;
        flex-wrap: wrap;
        background: #fff;
        width: 900px;
        padding: 10px 20px;
      "
    >
      <div class="message" v-for="(item, index) in userGoods" :key="index">
        <img
          v-if="item.picture"
          :src="$store.state.imgShowRoad + '/file/' + item.picture"
        />
        <img v-else src="../assets/img/wutu.gif" style="height: 177px" />
        <div class="info">
          <div class="title">{{ item.title }}</div>
          <div class="item-style">
            发起人：<span class="initiator">{{ item.ownName }}</span>
          </div>
          <div class="content initiator">{{ item.content }}</div>
          <div class="price">￥ {{ item.price }}</div>
          <div class="published-message-operation">
            <span @click.once="changeInfo(item.orderId)">
              <change-message
                :cupdateGoodInfo="updateGoodInfo"
              ></change-message>
            </span>
            <span @click.stop="deleteInfo(item.orderId)">
              <delete-message></delete-message>
            </span>&nbsp;&nbsp;&nbsp;
            <span class="down" v-if="$store.getters.isAdmin&&item.orderStatus==0&&item.type!='needs'" @click="takeDown(item.orderId)">下架</span>
            <span class="down" v-if="$store.getters.isAdmin&&item.orderStatus==1&&item.type!='needs'" @click="takeUp(item.orderId)">上架</span>
          </div>
        </div>
      </div>
      <Pagination
        @item-click="pageClick"
        :cUrl="url + ctype + '/'"
        :cTotal="total"
        :cPageSize="pageSize"
      ></Pagination>
    </div>
  </div>
</template>

<script>
import { selectOrderById, selectOrderByUsernameAndType,takeDown,takeUp } from "../api/order";
import ChangeMessage from "./ChangeMessage.vue";
import DeleteMessage from "./DeleteMessage.vue";
import Pagination from "./Pagination.vue";

export default {
  data() {
    return {
      userGoods: [],
      updateGoodInfo: {},
      pageNum: 1,
      searchValue: "",
      total: 0,
      pageSize: 30,
      url: "/order/search/",
    };
  },
  components: { ChangeMessage, DeleteMessage, Pagination },
  props: {
    ctype: {
      type: String,
    },
    cdesciibe: {
      type: String,
    },
  },
  methods: {
    takeDown(item){
      takeDown({item:item}).then((res) => {
          this.getData()
        })
        .catch((err) => {
          console.log(err);
        });
    },
    takeUp(item){
takeUp({item:item}).then((res) => {
          this.getData()
        })
        .catch((err) => {
          console.log(err);
        });
    },
    pageClick(item) {
      console.log("item", item);
      this.userGoods = item;
    },
    publishClick() {
      console.log("this.ctype", this.ctype);
      this.$router
        .push("/home/addmessage/publish" + this.ctype)
        .catch((err) => err);
    },
    changeInfo(item) {
      this.$store.commit("updateChangedOrderId", item);
      selectOrderById({
        order_id: this.$store.state.changedOrderId,
      })
        .then((res) => {
          this.updateGoodInfo = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteInfo(item) {
      this.$store.commit("updateChangedOrderId", item);
    },
    handleSearch() {
      this.getData();
    },
    getData() {
      selectOrderByUsernameAndType({
        ctype: this.ctype,
        pageNum: this.pageNum,
        keys: this.searchValue,
      })
        .then((res) => {
          this.userGoods = res.data.list;
          this.total = res.data.total;
        })
        .catch((err) => {
          console.log(err);
        });
    },
  },
  created() {
    this.getData();
  },
};
</script>

<style lang="less" scoped>
.search {
  height: 60px;
  background-color: white;
  padding: 10px 20px;
  background-color: white;
  margin-top: 10px;
  .search-icon {
    position: relative;
    bottom: 2px;
    left: -2px;
    cursor: pointer;
  }
}
.published-message {
  width: 900px;
  margin: 0 auto;
  height: 100%;
  background: #fff;

  .message {
    box-sizing: border-box;
    width: 410px;
    height: 180px;
    border: 1px solid #f2f2f2;
    background-color: white;
    border-radius: 6px;
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    margin: 10px 20px 10px 0;
    background: #fff;
    // padding: 10px 20px;
    img {
      width: 200px;
      height: 180px;
      margin-right: 10px;
      border-radius: 6px;
    }
    .info {
      margin-top: 10px;
      .item-style {
        height: 20px;
        line-height: 20px;
      }
      .initiator {
        color: #666;
      }
      .title {
        font-size: 16px;
        height: 30px;
        /*超出的部分隐藏*/
        overflow: hidden;
        /*文字用省略号替代超出的部分*/
        text-overflow: ellipsis;
        /*弹性伸缩盒子模型显示*/
        display: -webkit-box;
        /*限制在一个块元素显示文本的行数*/
        -webkit-line-clamp: 3;
        /*设置或检索伸缩盒对象的子元素排列方式*/
        -webkit-box-orient: vertical;
      }
      .content {
        width: 170px;
        line-height: 20px;
        max-height: 80px !important;
        margin-top: 10px;
        word-break: break-all;
        /*超出的部分隐藏*/
        overflow: hidden;
        /*文字用省略号替代超出的部分*/
        text-overflow: ellipsis;
        /*弹性伸缩盒子模型显示*/
        display: -webkit-box;
        /*限制在一个块元素显示文本的行数*/
        -webkit-line-clamp: 3;
        /*设置或检索伸缩盒对象的子元素排列方式*/
        -webkit-box-orient: vertical;
      }
      .price {
        font-size: 16px;
        font-weight: bold;
        display: block;
        color: red;
      }
    }
  }
  .published-message-operation {
    margin-bottom: 5px;
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    align-items: center;
    .down{
      height: 25px;
    cursor: pointer;
    margin-right: 10px;
    color: #67C23A;
    &:hover{
      color: #035D1C;
    }
    }
  }
}
.search /deep/ .el-input--suffix .el-input__inner {
  height: 35px;
  line-height: 35px;
}
</style>
