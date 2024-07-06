<template>


<div class="knowledge-box">
  <div class="knowledge" v-for="(item, index) in cknowledges" :key="index">
    <div class="flipper" >
      <div class="front">
        <video class="knowledge-img" width="200px" height="160px" v-if="item.type==='mp4'||item.type==='MP4'" accept="MP4,mp4" :src="$store.state.imgShowRoad + '/file/' + item.picPath" controls autoplay/>
        <img v-else class="knowledge-img" :src="$store.state.imgShowRoad + '/file/' + item.picPath" alt="" />
        <div class="front-title">{{ item.title }}</div>
      </div>
      <div class="back">
        <h3 class="back-title" @click="handleDetail(item)">{{ item.title }}</h3>
        <p class="content">{{ item.content }}</p>
        <span class="initiator">
          <img src="../../assets/img/up-user.png" @click="handleDetail(item)"/>
          {{item.ownName}}
        </span>
      </div>
    </div>
  </div>
</div>

</template>

<script>
export default {
  props: {
    cknowledges: {
      type: Array,
    },
  },
  methods:{
    handleDetail(item){
      this.$router.push(`/home/knowledge/${item.knowledgeId}`)
    }
  }
};
</script>

<style lang="less" scoped>
.knowledge-box {
  width: 1100px;
  margin: 0 auto;
  background-color: #f6f6f6;
  display: flex;
  flex-direction: row;
  justify-content: flex-start;
  flex-wrap: wrap;
  .knowledge {
    width: 500px;
    height:250px;
    padding: 20px;
    border-radius: 10px;
    background-color: white;
    margin: 10px;
    perspective: 1000px;
    .flipper {
      transition: 0.6s;
      transform-style: preserve-3d;
      position: relative;

      .front{
        z-index: 2;
        backface-visibility: hidden;
        position: absolute;
        video{
          border: 1px solid #f2f2f2;
          border-radius: 6px;
          backface-visibility: hidden;
          position: absolute;
        }
        .knowledge-img {
          float: left;
          width: 460px;
          height: 210px;
          margin-right: 10px;
          border-radius: 6px;
          filter: brightness(50%);
          box-shadow: 0px 0px 10px #393939;
        }
        .front-title{

          width: 460px;
          height: 210px;
          //内容居中
          text-align: center;
          display: flex;
          /*实现垂直居中*/
          align-items: center;
          /*实现水平居中*/
          justify-content: center;

          //div位置叠在图片上面
          position: absolute;
          top: 0;
          left: 0;

          //标题样式
          color: white;
          font-weight: bold;
          font-family: 鸿蒙字体Regular;
          font-size: 25px;
        }
      }
      .back{
        .back-title {
          font-weight: bold;
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
          cursor: pointer;
          &:hover{
            color: #035D1C;
            text-decoration: underline;
          }
        }
        width: 460px;
        margin-top: -10px;
        float: left;
        backface-visibility: hidden;
        position: absolute;
        transform: rotateY(180deg);
        .content {
          font-family: 鸿蒙字体Regular;
          font-size:15px;
          font-weight: bold;
          height: 130px;
          /*超出的部分隐藏*/
          overflow: hidden;
          /*文字用省略号替代超出的部分*/
          text-overflow: ellipsis;
          /*弹性伸缩盒子模型显示*/
          display: -webkit-box;
          /*限制在一个块元素显示文本的行数*/
          -webkit-line-clamp: 5;
          /*设置或检索伸缩盒对象的子元素排列方式*/
          -webkit-box-orient: vertical;
        }
        .initiator {
          color: #bfbfbf;
          img {
            margin: 0;
            padding: 0;
            width: 20px;
            height: 20px;
            margin-right: 10px;
            vertical-align: center;
            border-radius: 6px;
          }
        }

      }
    }

  }
}





/* flip the pane when hovered */
.knowledge:hover .flipper, .knowledge.hover .flipper {
  transform: rotateY(180deg);
}



@keyframes flip{
  0% {
    transform: rotateY(0deg) scale(1);
  }
  50% {
    transform: rotateY(90deg) scale(1.2);
  }
  100% {
    transform: rotateY(180deg) scale(1);
  }
}

</style>
