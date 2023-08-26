<template>
  <div class="goods-box">
    <div class="search2">
      <el-input  placeholder="请输入内容" v-model="searchValue" maxlength="100" clearable style="width:250px;margin-right: 5px">
        <i slot="prefix" class="el-input__icon el-icon-search search-icon" @click="handleSearch"  ></i>
      </el-input>

      <el-button-group>
        <el-button round @click="handleTopicDetail('')" >全部 </el-button>
        <el-button round @click="handleTopicDetail('苹果')"> 苹果 </el-button>
        <el-button round @click="handleTopicDetail('新疆哈密瓜')" style="width: 120px">新疆哈密瓜 </el-button>
        <el-button round @click="handleTopicDetail('樱桃')"> 樱桃</el-button>
        <el-button round @click="handleTopicDetail('西红柿')"> 西红柿 </el-button>
        <el-button round @click="handleTopicDetail('水稻')"> 水稻 </el-button>
        <el-button round @click="handleTopicDetail('玉米')"> 玉米 </el-button>
        <el-button round @click="handleTopicDetail('赣南脐橙')" style="width: 110px" > 赣南脐橙 </el-button>
      </el-button-group>


    </div>

    <div class="goods" v-for="(item, index) in cgoods"
         :key="index" @click="detailsClick(item.orderId)" :style="(index+1)%4===0?'margin-right:0':'margin-right:44px;'">
      <img class="goods-img" v-if="item.picture!=''" :src="$store.state.imgShowRoad + '/file/' + item.picture" alt="" />
      <img class="goods-img" v-if="item.picture==''" :src="$store.state.imgShowRoad + '/file/' + 'wutu.gif'" alt="" />
      <div style="text-align: right;height:250px">
        <el-tooltip
            class="box-item"
            effect="dark"
            content="加入购物车"
            placement="top-start"
        >
          <i class="el-icon-shopping-cart-2 icon" @click="addShopcartClick(item.orderId)"></i>
        </el-tooltip>
        <el-tooltip
            class="box-item"
            effect="dark"
            content="查看详情"
            placement="top-start"
        >
          <i class="el-icon-d-arrow-right icon"  @click="detailsClick(item.orderId)"></i>


        </el-tooltip>
      </div>
      <div class="info">

        <p class="content">{{ item.content }}</p>
        <div style="padding:0px 15px;display:flex;align-items: center;">
          <span class="price" v-if="item.price">￥{{ item.price }}</span>
          <span class="initiator">来自:{{ item.ownName }}</span>
        </div>
      </div>
    </div>

<!--    <el-card  class="goods card"  v-for="(item, index) in cgoods" :key="index" @click="" :style="(index+1)%4===0?'margin-right:0':'margin-right:25px;'" >-->
<!--      <img class="goods-img" v-if="item.picture !== ''" :src="`${$store.state.imgShowRoad}/file/${item.picture}`" alt="" />-->
<!--      <img class="goods-img" v-else :src="`${$store.state.imgShowRoad}/file/wutu.gif`" alt="" />-->


<!--      <div class="info">-->
<!--        <p class="content">{{ item.content }}</p>-->
<!--        <div style="display: flex;align-items: center">-->
<!--          <span class="price" v-if="item.price">￥{{ item.price }}</span>-->
<!--          <span class="initiator">卖家：{{ item.ownName }}</span>-->
<!--        </div>-->

<!--      </div>-->
<!--    </el-card>-->

  </div>
</template>

<script>
import {addOrderToCart} from "../../api/cart";

export default {
  data() {
    return {
      searchValue:''
    };
  },
  props: {
    cgoods: {
      type: Array,
    },
  },
  methods: {
    detailsClick(item) {
      this.$store.commit("updateOrderId", item);
      this.$router.push(`/home/details?orderId=${item}`).catch((err) => err);
    },
    handleSearch(){
      this.$emit('handleSearch',this.searchValue)
    },
    handleTopicDetail(val){
      this.searchValue = val
      this.handleSearch()
    },
    addShopcartClick(val) {
      addOrderToCart({
        order_id: val,
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
  },
};
</script>

<style lang="less" scoped>
.search2 {
  height: 60px;
  background-color: white;
  padding: 10px 10px;
  background-color: white;
  margin-top: 10px;
  .tag-item{
    margin-right: 10px;
    cursor: pointer;
  }
  .search-icon{
    position:relative;
    bottom:2px;
    left: -2px;
    cursor: pointer;
  }



}


.goods-box {
  background-color: #f9f9f9;
  width: 1100px;
  margin: 0 auto;
  .goods {
    float: left;
    width: 240px;
    height: 370px;
    margin-top: 15px;
    background-color: white;
    border: 1px solid #d3d3d3;
    cursor: pointer;
    border-radius: 10px;
    .goods-img {
      float: left;
      width: 240px;
      height: 240px;
      margin-right: 10px;
      border-radius: 6px;
    }
    .info {
      width: 240px;
      float: left;

      .initiator {
        color: #666;
        font-size: 15px;
        font-family: 苹果字体Black;
        text-align: right;
        width: 70%;
      }
      .title {
        /*超出的部分隐藏*/
        overflow: hidden;
        /*文字用省略号替代超出的部分*/
        text-overflow: ellipsis;
        /*弹性伸缩盒子模型显示*/
        display: -webkit-box;
        /*限制在一个块元素显示文本的行数*/
        -webkit-line-clamp: 1;
        /*设置或检索伸缩盒对象的子元素排列方式*/
        -webkit-box-orient: vertical;
      }
      .content {
        padding:15px ;
        height: 80px;
        /*超出的部分隐藏*/
        overflow: hidden;
        /*文字用省略号替代超出的部分*/
        text-overflow: ellipsis;
        /*弹性伸缩盒子模型显示*/
        display: -webkit-box;
        /*限制在一个块元素显示文本的行数*/
        -webkit-line-clamp: 7;
        /*设置或检索伸缩盒对象的子元素排列方式*/
        -webkit-box-orient: vertical;
        font-size: 16px;
        font-family: 苹果字体Black;
        font-weight: 600;

      }
      .price {
        font-size: 17px;
        font-weight: bold;
        display: block;
        color: red;
        width:40%;
      }
    }
  }
}
.search2 /deep/ .el-input--suffix .el-input__inner{
  height: 35px;
  line-height: 35px;
}


.goods,.icon{
  -webkit-transform: perspective(1px) translateZ(0);
  transform: perspective(1px) translateZ(0);
  -webkit-transition-duration: 0.3s;
  transition-duration: 0.3s;
  -webkit-transition-property: box-shadow, transform;
  transition-property: box-shadow, transform;
}


.icon{
  position:relative;
  padding: 0.5em;
  font-size:20px;
  color: white;
  background-color:#4ab344;
  border-radius: 50%;
  box-shadow: 0.2em 0.2em 0.2em  #888888;
  top:-22px;
  margin-right: 15px;

}

.icon:hover{
  box-shadow: 0em 0em 14px black;
  -webkit-transform: scale(1.1);
  transform: scale(1.1);
}

.goods:hover{
  box-shadow: 0em 0em 15px black;
  -webkit-transform: scale(1.1);
  transform: scale(1.03);
}

.card{
  margin: 10px 0px;height:360px
}

.card:hover{
  box-shadow:0em 0em 2em #343434;
}


::v-deep .el-button-group>.el-button {
  border-radius: 100px;
  margin:0px 5px;
  border: 1px solid #DCDFE6;
  &:hover{
    text-decoration: underline;
    background-color: #ffffff;
    color: black;
  }
  &:focus{
    color: #ff4f16;
    background-color: #ffffff;
  }
}

::v-deep .el-button-group>.el-button:not(:first-child):not(:last-child) {
  border-radius: 100px;
}
</style>
