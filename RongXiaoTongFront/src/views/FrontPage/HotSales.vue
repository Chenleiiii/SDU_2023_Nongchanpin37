<template>
  <div style="margin-top:110px;text-align: center">
    <Subtitle subtitle="热门商品" description="自然之宝，滋养味蕾；质量保证，健康共享"/>
    <div  style="margin: 50px 200px">

      <el-row :gutter="17">
        <el-col :span="13">
          <img :src="require(`@/assets/page1/HotSales/苹果系列.jpg`)" alt="" style="height: 340px" >
        </el-col>
        <el-col :span="11">
          <div class="left">
            <span style="line-height: 28px">
              <div style="text-align: left">
                <b style>
                  <span style="font-size: 28px;color: rgb(33, 33, 33);">苹果系列</span>
                  <span style="font-size: 14px;color: rgb(169, 169, 169);">FRENCH BULLDOG</span>
                </b>
              </div>
              <div style="text-align: left;"><span style="font-size: 15px;color: #666666">蔷薇科苹果属植物</span></div>

            </span>
            <div style="text-align: left;">
              <span style="font-size: 15px;">
                <font style="color: rgb(222, 222, 222);">———————————————————————————————</font>
              </span>
            </div>
            <div style="text-align: left;">
              <span style="font-size: 14px;color: #666666">
                <span style="line-height: 35px;">苹果原产欧洲中部、伊朗北部、俄罗斯高加索南部一带，中国主要分布在新疆、宁夏地区，一般生长在山坡梯田、平原矿野以及丘陵等地。苹果喜光、耐寒、要求较冷凉及干燥的气候，不耐瘠薄，适生于土质疏松、深厚肥沃、排水良好的中性或微酸性的砂质壤土。繁殖方式有块茎法、嫁接法、播种法、扦插法，自然繁殖</span>
              </span>
            </div>
          </div>
        </el-col>
      </el-row >
      <el-row :gutter="0" style="width: 1770px">
          <div class="right">
            <span style="line-height: 28px">
              <div style="text-align: left">
                <b style>
                  <span style="font-size: 28px;color: rgb(33, 33, 33);">凤梨系列</span>
                  <span style="font-size: 14px;color: rgb(169, 169, 169);">GOLDEN RETIEVER</span>
                </b>
              </div>
              <div style="text-align: left;"><span style="font-size: 15px;color: #666666">凤梨科凤梨属植物</span></div>
            </span>
            <div style="text-align: left;">
              <span style="font-size: 15px;">
                <font style="color: rgb(222, 222, 222);">———————————————————————————————</font>
              </span>
            </div>
            <div style="text-align: left;">
              <span style="font-size: 14px;color: #666666">
                <span style="line-height: 35px;">
                  菠萝原产于南美洲巴西、巴拉圭的亚马逊河流域一带，16世纪从巴西传入中国。 已经流传到整个热带地区。其可食部分主要由肉质增大之花序轴、螺旋状排列于外周的花组成，花通常不结实，宿存的花被裂片围成一空腔，腔内藏有萎缩的雄蕊和花柱。叶的纤维甚坚韧，可供织物、制绳、结网和造纸。
                </span>
              </span>
            </div>
          </div>



          <img :src="require(`@/assets/page1/HotSales/凤梨系列.jpg`)"  style="height: 340px" >

      </el-row>
      <el-row :gutter="17" >
        <el-col :span="13" >
          <img :src="require(`@/assets/page1/HotSales/草莓系列.jpg`)" alt="" style="height: 340px">
        </el-col>
        <el-col :span="11">
          <div class="left">
            <span style="line-height: 28px">
              <div style="text-align: left">
                <b style>
                  <span style="font-size: 28px;color: rgb(33, 33, 33);">草莓系列</span>
                  <span style="font-size: 14px;color: rgb(169, 169, 169);">SAMOYED</span>
                </b>
              </div>
              <div style="text-align: left;"><span style="font-size: 15px;color: #666666">蔷薇科草莓属植物</span></div>

            </span>
            <div style="text-align: left;">
              <span style="font-size: 15px;">
                <font style="color: rgb(222, 222, 222);">———————————————————————————————</font>
              </span>
            </div>
            <div style="text-align: left;">
              <span style="font-size: 14px;color: #666666">
                <span style="line-height: 35px;">
                草莓具有较高的营养价值、医疗价值和生态价值。草莓浆果芳香多汁，营养丰富，素有“水果皇后”的美称，又是果树中上市最早的鲜果，素有“早春第一果”的美称。草莓含有较高的维生素、钙、磷、铁等营养物质，且草莓中含有众多活性物质，可清凉止渴，健胃消食的功效，具有一定的医疗价值。草莓也可作为观赏、绿化植物，已成为中国西部地区农民脱贫致富的首选作物</span>
              </span>
            </div>
          </div>
        </el-col>
      </el-row >

    </div>

  </div>
</template>

<script>
import Subtitle from "../../components/Subtitle";

export default {
  name: "HotSales",
  components:{
    Subtitle
  }
}
</script>

<style scoped>

.left{
  position: absolute;
  top: 60px;
  left: 650px;
  width: 504px;
  height: auto;
  animation: 0s ease 0s 1 normal none running none;
}
.right{
  position: absolute;
  top: 60px;
  left:80px;
  width: 504px;
  height: auto;
  animation: 0s ease 0s 1 normal none running none;
}
</style>
