<template>
  <div class="questions-container">
    <Subtitle subtitle="常见问题" description="大家都在问的问题哦~"  style="margin-top:100px;"/>
    <div class="questions">
      <el-row :gutter="80">
        <el-col :span="8"  >
          <el-card shadow="always" class="card" @click="handleTopicDetail('苹果果树种植方法')"> 苹果果树种植方法?</el-card>
        </el-col>
        <el-col :span="8">
          <el-card shadow="always" class="card" @click="handleTopicDetail('苹果果树种植方法')"> 新疆哈密瓜甜度控制? </el-card>
        </el-col>
        <el-col :span="8">
          <el-card shadow="always" class="card" @click="handleTopicDetail('苹果果树种植方法')"> 玉米苗灌溉? </el-card>
        </el-col>
      </el-row>
    </div>

  </div>

</template>

<script>
import Subtitle from "../../components/Subtitle";
import GuideSource from "./GuideSource";

export default {
  name: "Questions",
  components:{
    Subtitle,

  },
  methods:{
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
  }
}
</script>

<style scoped>
.questions-container{
  text-align: center;

}

.questions{
  width: 100%;
  display: flex;
  justify-content: center;
}
.card{
  border-radius: 5px;
  width: 300px;
  height: 200px;
  display: flex;
  align-items: center;
  justify-content: center;
  font-weight: bold;
  font-size: 20px;
  font-family: 鸿蒙字体Regular;
}

::v-deep .el-card{
  border-radius: 10px;
  background-color: #f1f1f1;
  box-shadow: 0px 0px 10px #959595;
}

::v-deep .el-card:hover{
  border-radius: 10px;
  box-shadow: 0px 0px 20px #828282;
}

</style>
