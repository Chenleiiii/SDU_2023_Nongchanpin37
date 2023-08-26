<!--专家指导-->
<template>
  <div>

    <img src="../../assets/page5/background5.jpg" alt="">
    <Questions />

    <div class="home-guide-container">
        <guide-source :cgoods="goods" :pageSize="pageSize" :url="url" :total="total" @handleSearch="handleSearch" @pageClick="pageClick"></guide-source>
    </div>

    <AllExpert />

  </div>

</template>
<script>
import { selectQuestions,selectExpert } from "../../api/order";
import GuideSource from "./GuideSource.vue";
import Subtitle from "../../components/Subtitle";
import Questions from "./Questions";
import AllExpert from "./AllExpert";

export default {
  data() {
    return {
      goods: [],
      total: 0,
      searchValue:'',
      pageSize: 30,
      url: "/order/goods/",
      expertCount:1,
      guideCount: sessionStorage.getItem("/order/goods/pageCode")
        ? sessionStorage.getItem("/order/goods/pageCode")
        : 1,
      expertArray:[]
    };
  },
  created() {
    if (this.$store.state.token == "") {
      alert;
    }
    this.$store.commit("updateActiveIndex", "5");
    this.getData()
    this.getExpertData()
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
      selectQuestions({
        pageNum: this.guideCount,
        keys:this.searchValue
      }).then((res) => {
        if (res.flag == true) {
          this.goods = res.data.list;
          this.total = res.data.total;
        } else {
          // alert(res.message);
        }
      }).catch(err=>{
        console.log(err)
      })
    },
    getExpertData(){
      selectExpert({
        pageNum: this.expertCount,
        keys:this.searchValue
      }).then(res => {
        if(res.flag == true){
          this.expertArray = res.data.list
        }else{
          this.$message.error(res.message);
        }
      }).catch(err=>{
        console.log(err)
      })
    },
    handleQuestion(item){
      if(localStorage.getItem('token')){
        this.$router.push(`/home/question?id=${item.userName}`).catch((err) => err);
      }else{
        this.$message.error('请先登录')
        this.$router.push(`/login`).catch((err) => err);
      }
    },
    handleAppointment(item){
      if(localStorage.getItem('token')){
        this.$router.push(`/home/appointment?id=${item.userName}`).catch((err) => err);
      }else{
        this.$message.error('请先登录')
        this.$router.push(`/login`).catch((err) => err);
      }
    }
  },
  components: {
    GuideSource,
    Subtitle,
    Questions,
    AllExpert
  },
};
</script>

<style lang="less" scoped>
.home-guide-container{
  width: 1100px;
  margin: 0 auto;
  display: flex;
  justify-content: space-between;
}


.epert {
  min-height: 80px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-top: 20px;
  align-items: center;
  // padding: 10px 10px;
  img {
    width: 80px;
    height: 80px;
    margin-right: 10px;
    border-radius: 6px;
  }
  .item-style{
    display: flex;
    flex-direction: row;
    justify-content: space-between;
  }
  p {
    margin: 5px;
  }
  .content{
    color:#333;
    font-size:12px;
    font-style:normal;
    width: 120px;
    line-height: 25px;
  }
  .item-content{
    width: 220px;
    line-height: 25px;
    /*超出的部分隐藏*/
    overflow: hidden;
    /*文字用省略号替代超出的部分*/
    text-overflow: ellipsis;
    word-break: break-all;
    /*弹性伸缩盒子模型显示*/
    display: -webkit-box;
    /*限制在一个块元素显示文本的行数*/
    -webkit-line-clamp: 2;
    /*设置或检索伸缩盒对象的子元素排列方式*/
    -webkit-box-orient: vertical;
  }
  .item-btn{
    display: flex;
    flex-direction: row;
    justify-content: flex-end;
    margin-bottom: 10px;
    margin-right: 10px;
    color: #67C23A;
    .btn-item{
      margin-left: 10px;
      cursor: pointer;
      &:hover{
        text-decoration: underline;
        color: #035D1C;
      }
    }
  }
}
</style>
