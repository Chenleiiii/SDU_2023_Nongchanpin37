<!--从首页进入，关于商品细节的页面-->

<template>
  <div class="details-box">
    <img v-if="data.picture" :src="$store.state.imgShowRoad + '/file/' + data.picture" alt="" />
    <img v-else src="../../assets/img/wutu.gif" alt="" style="border:1px solid #f2f2f2;"/>
    <div class="info">
      <h4 class="title">{{ data.title }}</h4>
      <div class="content" :title="data.content">{{ data.content }}</div>
      <span class="price">￥{{ data.price }}</span>
      <div class="time">
        <span style="margin-right:30px;">发布时间：{{ data.createTime | changeTime }}</span>
        <span>最近修改时间：{{ data.updateTime | changeTime }}</span>
      </div>
      <div class="item-style">
        <div class="operation">
          <div class="operation-item"><img src="../../assets/img/good.png" class="operation-img" alt="" /> 点赞</div>
          <div class="operation-item"><img src="../../assets/img/no-star.png" class="operation-img" alt="" /> 收藏</div>
          <div class="operation-item"><img src="../../assets/img/fill-in.png" class="operation-img" alt="" />评论</div>
        </div>
        <div class="btn-content">
          <el-button type="success" plain round @click="addShopcartClick" v-if="data.type == 'goods'">加入购物车</el-button>
          <el-popover placement="right" width="320" trigger="hover">
            <div>
              <div class="item-sales">卖家姓名：<span class="sales-text">{{updateUserData.userName}}</span></div>
              <div class="item-sales">卖家地址：<span class="sales-text">{{updateUserData.address}}</span></div>
              <div class="item-sales">卖家手机号码：<span class="sales-text">{{updateUserData.phone}}</span></div>
              <div class="item-sales">更新时间：<span class="sales-text">{{updateUserData.updateTime | formatTimer}}</span></div>
            </div>
            <el-button type="danger" slot="reference" @click.once="changeInfo(item.orderId)" v-show="data.type == 'needs'">联系买家</el-button>
          </el-popover>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { addOrderToCart } from "../../api/cart";
import { selectOrderById } from "../../api/order";
import ChangeMessage from "../../components/ChangeMessage.vue";
import { selectUserByUsername } from "../../api/user";

export default {
  data() {
    return {
      data: [],
      ownerInfo: {},
      userGoods: [],
      updateGoodInfo: {},
      updateUserData:{}
    };
  },
  filters: {
    changeTime(time) {
      return time.slice(0, 10);
    },
    formatTimer: function(value) {
      let date = new Date(value);
      let y = date.getFullYear();
      let MM = date.getMonth() + 1;
      MM = MM < 10 ? "0" + MM : MM;
      let d = date.getDate();
      d = d < 10 ? "0" + d : d;
      let h = date.getHours();
      h = h < 10 ? "0" + h : h;
      let m = date.getMinutes();
      m = m < 10 ? "0" + m : m;
      let s = date.getSeconds();
      s = s < 10 ? "0" + s : s;
      return y + "-" + MM + "-" + d + " ";
    }
  },
  components: { ChangeMessage },
  props: {
    ctype: {
      type: String,
    },
    cdesciibe: {
      type: String,
    },
  },
  methods: {
    addShopcartClick() {
      addOrderToCart({
        order_id: this.data.orderId,
      })
        .then((res) => {
          console.log(res);
          if (res.flag == true) {
            alert(res.message);
          } else {
            alert(res.message);
          }
        })
        .catch((err) => {
          alert("添加失败,请先登录");
        });
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
    getSalesInfo(){
      selectUserByUsername({
        user_name: this.data.ownName,
      }).then((res) => {
        this.updateUserData = res.data;
      }).catch(err=>{
        console.log(err);
      })
    }
  },
  mounted() {

    selectOrderById({
      order_id: this.$route.query.orderId,
    }).then((res) => {
      if (res.flag == true) {
        this.data = res.data;

        this.getSalesInfo()
      }
    });
  },
};
</script>

<style lang="less" scoped>
.details-box {
  width: 1100px;
  height: 100%;
  margin: 20px auto;
  padding: 20px;
  padding-right: 50px;
  padding-left: 50px;
  background: #fff;
  display: flex;
  justify-content: space-between;
  img {
    width: 300px;
    height: 300px;
    border-radius: 6px;
  }
  .info {
    position: relative;
    width: 680px;
    height: 300px;
    border: 1px solid #f2f2f2;
    // box-shadow: 3px 3px 3px rgba(3, 0, 0, 0.07);
    border-radius: 6px;
    padding: 10px 20px;
    .title {
      font-size: 22px;
      font-weight: bold;
    }
    .content {
      height: 100px;
      border: 1px dashed #f2f2f2;
      line-height: 23px;
      padding: 5px 10px;
      /*超出的部分隐藏*/
      overflow: hidden;
      /*文字用省略号替代超出的部分*/
      text-overflow: ellipsis;
      /*弹性伸缩盒子模型显示*/
      display: -webkit-box;
      /*限制在一个块元素显示文本的行数*/
      -webkit-line-clamp: 4;
      /*设置或检索伸缩盒对象的子元素排列方式*/
      -webkit-box-orient: vertical;
    }
    .price {
      color: red;
      font-size: 25px;
      font-weight: bold;
    }
    .time {
      margin-top: 5px;
      color: #999;
      display: flex;
      justify-content: flex-start;
    }
    .item-style{
      display: flex;
      flex-direction: row;
      justify-content: flex-start;
      margin-top: 5px;
      align-items: center;
    }
  }
  .operation {
    display: flex;
    margin-top: 10px;
    margin-right: 150px;
    .operation-item{
      display: flex;
      flex-direction: column;
      justify-content: center;
      align-items: center;
      margin-right: 10px;
      .operation-img{
        width: 20px;
        height: 20px;
        margin-bottom: 5px;
        border-radius: 6px;
      }
    }
  }
  .btn-content{
    margin-top: 10px;
  }
  .item-sales{
    color: #333 !important;
    line-height: 30px;
    max-height: 30px;
    .sales-text{
      color: #666;
    }
  }
}
</style>
