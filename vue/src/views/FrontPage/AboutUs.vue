<template>

  <div class="about-us-container">
    <Subtitle subtitle="关于我们" description="超越期望，满足你的每一个需求"/>

    <div style="display: flex;justify-content: center;padding: 0px 200px">
      <el-row :gutter="20">
        <el-col :span="8">
          <div  class="title" >
            <div style="font-size: 40px">关于我们</div>
            <div>ABOUT US</div>
            <div>——</div>
          </div>
        </el-col>
        <el-col :span="14">
          <div class="content">
            <h3 style="text-indent:30px;color: #4ab344">项目介绍：</h3>
            <p style="text-indent: 2em;">融销通是一款基于数字经济的农产品融销一体平台</p>
            <p style="text-indent: 2em;">从用户的角度出发，能够很好的支持农户进行产销购入等活动：针对性性强，使用简便，农户进行买卖商品，联系客户时，操作简单易于理解。将农产品求购与货源同
              时展出，提高了成功率。长此以往将形成一个良性循环。</p>
            <p style="text-indent: 2em">融销通支持农业专家进行知识分享，解惑答疑等工作，农户不仅在网站平台上进行商品的买卖，如果遇到有关问题，可以
              线上与专家讨论，搜索相关知识，也可以与专家线下预约，解决农业问题</p>
            <p style="text-indent: 2em">同时，平台也提供了一个良好的银行与用户进行融资的环境，农户用户作为贷款很大的群体，实际中却不尽人意，银行方面，难以获取实际需求用户，难以了解用户需求，农民方面，文化水平有限或单方面排斥，不能很好的相关获取信息，利用银行资源。平台瞄准需
              求，给银行推智能匹配客户，给农户开通融资申请接口，方便双方沟通，达到双赢。</p>



          </div>
        </el-col>
      </el-row>

    </div>

  </div>

</template>

<script>
import Subtitle from "../../components/Subtitle";

export default {
  name: "AboutUs",
  components:{
    Subtitle
  }
}
</script>

<style lang="less" scoped>
.about-us-container{
  text-align: center;
  margin-top:110px
}

.title{
  background-color: #4ab344;
  width:387px;
  height:460px;
  padding: 140px 0px;
  div{
    font-weight: 500;
    font-family: 鸿蒙字体Regular;
    font-size: 25px;
    color: white;
  }
}





.content{

  font-size: 17px;
  font-weight: 540;
  text-shadow: 0px 0px 1px #c7c7c7;
  text-align: left;
}
</style>
