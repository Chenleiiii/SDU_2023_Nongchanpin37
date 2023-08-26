<template>
  <div class="guide-detail-content">
    <div class="detail-item"><div class="item-text">问题：</div>{{detailObj.question}}</div>
    <div class="detail-item">
      <div class="item-text">回答：</div>
      <div class="detail-content">{{detailObj.answer}}</div>
    </div>
  </div>
</template>

<script>
import { questionDetail } from "../../api/order";

export default {
  data(){
    return{
      detailObj:{}
    }
  },
  methods:{
    getData(){
      questionDetail({id:this.$route.params.id}).then(res => {
        console.log('reeeee',res)
        this.detailObj = res.data
      }).catch(err=>{
        console.log(err)
      })
    }
  },
  mounted(){
    this.$store.commit("updateActiveIndex", "5");
    this.getData()
  }
}
</script>

<style lang="less" scoped>
.guide-detail-content{
  width: 1100px;
  height: 100%;
  background: #fff;
  margin: 10px auto;
  padding: 10px 20px;
  .detail-item{
    display: flex;
    align-items: center;
    border: 1px dashed darkseagreen;
    // background: #fff;
    margin: 10px 0;
    padding: 10px 20px;
    border-radius: 6px;
    display: flex;
    align-items: flex-start;
    .item-text{
      font-weight:bold;
      width: 50px;
    }
    .detail-content{
      width: 1000px;
      /*超出的部分隐藏*/
      overflow: hidden;
      /*文字用省略号替代超出的部分*/
      text-overflow: ellipsis;
      word-break: break-all;
      /*弹性伸缩盒子模型显示*/
      display: -webkit-box;
      /*限制在一个块元素显示文本的行数*/
      -webkit-line-clamp: 20;
      /*设置或检索伸缩盒对象的子元素排列方式*/
      -webkit-box-orient: vertical;
    }
  }
}
</style>
