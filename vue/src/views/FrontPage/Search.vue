<template>

  <div class="search-container">
    <div class="left">
      <i style="color:#FCFCFC;font-style:normal;">
        &nbsp;热门关键词：
        <a class="tag-item" @click="handleTopicDetail('苹果')">苹果</a>|
        <a class="tag-item" @click="handleTopicDetail('新疆哈密瓜')">新疆哈密瓜</a>|
        <a class="tag-item" @click="handleTopicDetail('樱桃')">樱桃</a>|
        <a class="tag-item" @click="handleTopicDetail('西红柿')">西红柿</a>|
        <a class="tag-item" @click="handleTopicDetail('水稻')">水稻</a>|
        <a class="tag-item" @click="handleTopicDetail('玉米')">玉米</a>|
        <a class="tag-item" @click="handleTopicDetail('赣南脐橙')">赣南脐橙</a>
      </i>

    </div>
    <div class="right">
      <el-input
          placeholder="请输入关键词"
          v-model="input">
        <i slot="prefix" class="el-input__icon el-icon-search"  ></i>
      </el-input>
    </div>

  </div>
</template>

<script>
export default {
  name: "Search",
  data(){
    return{
      input:''
    }
  },
  methods:{
    handleTopicDetail(val){
      this.$router.push("/home/goods/")
      this.searchValue = val
      this.handleSearch()
    },
  }

}
</script>

<style lang="less" scoped>

.search-container {
  background-color: #4ab344;
  width: 100%;
  height: 80px;
}

.left{
  position: relative;
  color: #ffffff;
  font-size: 16px;
  top: 30px;
  left: 200px;
  .tag-item{
    margin-left: 0px;
    margin-right: 2px;
    cursor: pointer;
    color: #FCFCFC;

  }
}


.right{
  position: relative;
  width: 15%;

  left:75%;
}


</style>
