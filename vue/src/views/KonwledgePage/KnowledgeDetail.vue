<!-- 农业知识详情 -->
<template>
  <div class="knowlege-detail-container">
    <div class="title">{{updateInfo.title}}</div>
    <div class="tips">
      <span>作者：</span>
      <span style="margin-right:20px;">{{updateInfo.ownName}}</span>
      <span>日期：</span>
      <span>{{updateInfo.updateTime | formatTimer}}</span>
    </div>
    <div class="detail-img">
      <video v-if="updateInfo.type==='mp4'||updateInfo.type==='MP4'" id="video" width="900" height="360" :src="$store.state.imgShowRoad + '/file/' + updateInfo.picPath" controls> </video>
      <img v-else style="width:657px;height:300px;" :src="$store.state.imgShowRoad + '/file/' + updateInfo.picPath" alt="" />
    </div>
    <div class="detail-content">
      <p>{{updateInfo.content}}</p>
    </div>

    <div class="comment-container">
      <div class="comment-num">评论共{{commentArray.length||0}}条</div>
      <div class="comment-item" v-for="(item,index) in commentArray" :key="index">
        <div>{{item.content}}</div>
        <div class="comment-tips">
          <div style="margin-right:40px;">评论人：<span class="color6">{{item.ownName}}</span></div>
          <div>评论时间：<span class="color6">{{item.createTime|formatTimer2}}</span></div>
        </div>

      </div>
      <div v-if="commentArray.length==0" style="width: 100%;text-align: center;margin: 50px 0px">
        <img src="../../assets/page4/noComments.png" alt="" >
      </div>

      <div class="comment-num">发表评论</div>
      <el-input type="textarea" v-model="content" :rows="5"></el-input>
      <div style="margin-top:20px;display: flex;flex-direction: row;justify-content: flex-end">
        <el-button type="success" plain @click="handleComment">添加评论</el-button>
      </div>
    </div>
  </div>
</template>

<script>
import { selectKnowledgeById,selectComment,addComment } from "../../api/knowledge";

export default {
  data(){
    return{
      updateInfo:{},
      content:'',
      commentArray:[]
    }
  },
  filters: {
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
    },
    formatTimer2: function(value) {
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
      return y + "-" + MM + "-" + d + " "+h+":"+m;
    }
  },
  methods:{
    getData(){
      this.$store.commit("updateActiveIndex", "4");
      selectKnowledgeById({
        knowledgeId: this.$route.params.id
      }).then((res) => {
        let tmp = res.data;
        const flieArr =  tmp.picPath.split('.')
        tmp.type = flieArr[flieArr.length - 1]
        this.updateInfo = tmp;
        console.log('this.updateInfo',this.updateInfo)
      })
      .catch((err) => {
        console.log(err);
      });
    },
    // 查询评论
    getCommentData(){
      selectComment({
        knowledgeId: this.$route.params.id
      }).then(res => {
        this.commentArray = res.data
      }).catch(err=>{
        console.log(err)
      })
    },
    handleComment(){
      if(this.content===''){
        this.$message.error('评论内容不能为空！')
        return
      }
      if(localStorage.getItem('token')){
        addComment({
          knowledgeId: this.$route.params.id,
          content: this.content
        }).then(res=>{
          this.content=''
          this.$message.success('评论成功！')
          this.getCommentData()
        }).catch(err=>{
          console.log(err)
        })
      }else{
        this.$message.error('请先登录')
      }
    }
  },
  mounted(){
    this.getData()
    this.getCommentData()


  }
}
</script>

<style lang="less" scoped>
.knowlege-detail-container{
  width: 1100px;

  margin: 0 auto;
  background: #fff;
  min-height: 1200px;
  padding: 10px 20px;
  margin-top: 30px;
  .title{
    font-size: 25px;
    text-align: center;
    font-weight: bold;
  }
  .tips{
    color: #999;
    display: flex;
    justify-content: flex-end;
    height: 30px;
    align-items: center;
  }
  .detail-img{
    display: flex;
    justify-content: center;
    margin-top: 40px;
    video{
      border: 1px solid #f2f2f2;
    }
    img{
      border-radius: 6px;
    }
  }
  .detail-content{
    font-size: 17px;
    margin-top: 20px;

  }
  .comment-container{
    clear: both;
    margin-top: 10px;
    .comment-num{
      font-weight: bold;
      font-size: 17px;
      margin-bottom: 10px;
    }
    .comment-item{
      border-bottom: 1px solid #f2f2f2;
      padding: 10px 20px;
      margin: 20px 0;
      word-break: break-all;
      .comment-tips{
        display: flex;
        flex-direction: row;
        justify-content: flex-end;
        .color6{
          color: #666;
        }
      }
    }
  }
}
</style>
