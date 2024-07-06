<template>
  <div class="goods-box3">
    <div >
      <el-input  placeholder="有问题直接搜" v-model="searchValue" maxlength="100" clearable style="width:700px;margin-right: 15px">
        <i slot="prefix" class="el-input__icon el-icon-search search-icon" @click="handleSearch"  ></i>
      </el-input>
      <el-button-group>
        <el-button round @click="handleTopicDetail('')" >全部 </el-button>
        <el-button round @click="handleTopicDetail('苹果果树种植方法')"> 苹果 </el-button>
        <el-button round @click="handleTopicDetail('玉米苗灌溉')"> 玉米 </el-button>
        <el-button round @click="handleTopicDetail('北方草莓种植品种')"> 草莓 </el-button>
      </el-button-group>
    </div>

    <div class="goods" v-for="(item, index) in cgoods" :key="index">
      <div class="info">
        <div class="content">
          <div style="display: flex;align-items: center">
            <div class="question-text" style="" >问</div>
            <div class="question-content" @click="handleDetail(item)">{{ item.title }}</div>
          </div>
          <div class="answer-container">
            <div class="answer-text" >答</div>
            <div class="answer-content" v-if="item.status == 1" >{{ item.answer }}</div>
          </div>



        </div>
        <div class="person-contents">
          <span>提问者：{{ item.questioner }}</span>&nbsp;&nbsp;&nbsp;
          <span>专家：{{ item.expertName }}</span>
        </div>
      </div>
    </div>
    <Pagination @item-click="pageClick" :cUrl="url" :cTotal="total" :cPageSize="pageSize"></Pagination>
  </div>
</template>

<script>
import Pagination from "../../components/Pagination.vue";

export default {
  data() {
    return {
      searchValue:''
    };
  },
  components:{
    Pagination
  },
  filters: {
    formatTimer: function (value) {
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
    },
  },
  props: {
    cgoods: {
      type: Array,
    },
    total:{
      type: Number
    },
    pageSize:{
      type: Number
    },
    url:{
      type: String
    }
  },
  methods: {
    detailsClick(item) {
      this.$store.commit("updateOrderId", item);
      this.$router.push(`/home/details?id=${item.id}`).catch((err) => err);
    },
    pageClick(val){
      this.$emit('pageClick',val)
    },
    handleSearch(){
      this.$emit('handleSearch',this.searchValue)
    },
    handleDetail(item){
      this.$router.push(`/home/guide/${item.id}`)
    },
    handleTopicDetail(val){
      this.searchValue = val
      this.handleSearch()
    }
  },
  mounted(){
    this.$store.commit("updateActiveIndex", "5");
  }
};
</script>

<style lang="less" scoped>
.search {
  width: 1100px;
  height: 35px;
  background-color: white;
  padding: 10px 20px;
  border-radius: 20px;
  .tag-item{
    margin-right: 8px;
    cursor: pointer;
  }
  .search-icon{
    position:relative;
    bottom:2px;
    left: -2px;
    cursor: pointer;
  }
}

.goods-box3 {
  width: 1100px;
  margin-top: 40px;
  .goods {
    width: 1100px;
    min-height: 80px;
    padding: 10px 20px;
    background-color: white;
    margin: 12px 0px;
    border-radius: 20px;
    border-bottom: 1px solid #f2f2f2;


    .info {
      width: 985px;
      font-weight: 100;
      font-size: 17px;
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
        width: 680px;
        line-height: 20px;
        display: block;

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
        .question-text{
          color: #ffffff;
          background-color: #ff4f16;
          border-radius: 3px;
          display: flex;
          align-items: center;
          justify-content: center;
          height: 25px;
          width: 25px;
          font-size: 15px;
          font-weight: bold;
          box-shadow: 0px 0px 5px #929292;
          margin-right: 10px;
        }
        .answer-container{
          width: 680px;
          margin-top: 15px;
          display: flex;
          align-items: center;
          -webkit-box-orient: vertical;
          .answer-text{
            color: #ffffff;
            background-color: #23c6c6;
            border-radius: 3px;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 25px;
            width: 25px;
            font-size: 15px;
            font-weight: bold;
            box-shadow: 0px 0px 5px #929292;
            margin-right: 10px;
          }
        }

      }
      .person-contents{
        height: 30px;
        align-items: end;
        display: flex;
        flex-direction: row;
        justify-content: flex-end;
        color: #666;
      }
      .price {
        font-size: 15px;
        font-weight: bold;
        display: block;
        color: red;
      }
    }
  }
}
.marginR5{
  margin-right: 5px;
}
.question-content{
  cursor: pointer;
  white-space:nowrap;
  overflow:hidden;
  text-overflow:ellipsis;
  width:658px;
  font-weight: bold;
  &:hover{
    text-decoration: underline;
    color: #035D1C;
  }
}
.answer-content{
  cursor: pointer;
  white-space:nowrap;
  overflow:hidden;
  text-overflow:ellipsis;
  width:658px;
}
.search /deep/ .el-input--suffix .el-input__inner{
  height: 35px;
  line-height: 35px;
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
