<template>
  <div class="published-message">
    <div style="padding:10px 20px 0">
      <el-button type="success" plain round @click="publishKnowledgeClick">发布知识</el-button>
    </div>
    <div class="publish-content">
      <div class="message" v-for="(item, index) in userKnowledges" :key="index" :style="(index+1)%2===0?'margin-right:0':'margin-right:20px'">
        <img v-if="item.picPath" class="knowleage-icon" :src="$store.state.imgShowRoad + '/file/' + item.picPath" alt="" />
        <img class="knowleage-icon" v-else src="../assets/img/wutu.gif">
        <div class="info">
          <h4 class="title">{{ item.title }}</h4>
          <span class="initiator">发起人：{{ item.ownName }}</span>
          <p class="content">{{ item.content }}</p>
          <div class="btns-style">
            <div @click.once="changeKnowledgeInfo(item.knowledgeId)"><change-knowledge :cupdateKnowledgeInfo="updateInfo"></change-knowledge></div>
            <div @click.stop="deleteKnowledgeInfo(item.knowledgeId)"><delete-knowledge></delete-knowledge></div>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import {
  selectKnowledgeById,
  selectKnowledgeByUsername,
} from "../api/knowledge";
import ChangeKnowledge from "./ChangeKnowledge.vue";
import DeleteKnowledge from "./DeleteKnowledge.vue";

export default {
  data() {
    return {
      userKnowledges: [],
      updateInfo: {},
    };
  },
  components: { DeleteKnowledge, ChangeKnowledge },
  methods: {
    publishKnowledgeClick() {
      this.$router
        .push("/home/addmessage/publishknowledges")
        .catch((err) => err);
    },
    changeKnowledgeInfo(item) {
      this.$store.commit("updateChangedKnowledgeId", item);
      selectKnowledgeById({
        knowledgeId: this.$store.state.changedKnowledgeId,
      })
        .then((res) => {
          this.updateInfo = res.data;
        })
        .catch((err) => {
          console.log(err);
        });
    },
    deleteKnowledgeInfo(item) {
      this.$store.commit("updateChangedKnowledgeId", item);
    },
  },
  created() {
    this.$store.commit("updateUserActiveIndex", "4-3");
    selectKnowledgeByUsername({})
      .then((res) => {
        this.userKnowledges = res.data;
      })
      .catch((err) => {
        console.log(err);
      });
  },
};
</script>

<style lang="less" scoped>
.published-message {
  margin: 0 auto;
  width: 900px;
  height: 100%;
  // display: flex;
  // flex-direction: row;
  // justify-content: flex-start;
  // flex-wrap: wrap;
  background: #fff;
  // padding: 0px 20px;
  .publish-content{
    background: #fff;
    display: flex;
    flex-wrap: wrap;
    padding: 10px 20px;
  }
  .message {
    width: 420px;
    height: 180px;
    border: 1px solid #f2f2f2;
    background-color: white;
    margin: 10px 0 10px;
    display: flex;
    flex-direction: row;
    justify-content: space-between;
    img{
      border-radius: 6px;
    }
    .knowleage-icon{
      width: 200px;
      height: 178px;
      margin-right: 10px;
      border-radius: 6px;
    }
    .info {
      width: 200px;
      padding: 0 10px;
      .initiator {
        color: #666;
      }
      .title{
        height: 30px;
        line-height: 30px;
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
        word-break: break-all;
      }
      .content {
        height: 75px;
        line-height: 25px;
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
        word-break: break-all;
      }
    }
    .btns-style{
      display: flex;
      flex-direction: row;
      justify-content: flex-end;
    }
  }
}
</style>
