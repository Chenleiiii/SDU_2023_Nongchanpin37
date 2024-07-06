<template>
  <el-carousel class="demonstration" trigger="click" >
    <el-carousel-item>
      <img src="../../assets/page1/Carouselimages/carousel1.jpg" style="height: 100%;"/>
      <div class="carousel-title1">
        <span class="big-font">裕</span><span class="small-font">则济天下</span> <span class="big-font">润</span ><span class="small-font">则四方</span> <span class="big-font">丰</span><span class="small-font">之收获</span>
        <div style="font: 20px 思源黑体heavy;color: rgb(145, 145, 133)">Give the economy moist quartet bumper harvest </div>
      </div>
    </el-carousel-item>
    <el-carousel-item >
      <img src="../../assets/page1/Carouselimages/carousel2.jpg" style="height: 100%;"/>
      <div class="carousel-title2">
        <div style="margin-left:78px;background-color: #F07C0A;color:white;height: 39px;width: 275px;font: 18px 思源黑体heavy;display:flex;align-items: center;justify-content: center">以质量求生存 以信誉求发展</div>
        <div style="margin-left:100px;margin-top:10px;color: #0E9821;font: 53px 思源黑体heavy;width: 494px;height: 116px">为您提供优质的产品和您满意的服务</div>
        <div style="margin-left:100px;margin-top:40px;color: #666666;font: 15px 微软雅黑;">TO PROVIDE YOU WITH QUALITY PRODUCTSAND</div>
      </div>
    </el-carousel-item>

  </el-carousel>
</template>

<script>
export default {
  name: "Carousel",
  data() {
    return {
      imgList: [
        {
          name: "carousel1",
          src: require("@/assets/page1/Carouselimages/carousel1.jpg"),
        },
        {
          name: "carousel2",
          src: require("@/assets/page1/Carouselimages/carousel2.jpg"),
        },
      ]
    };
  },
}
</script>

<style lang="less" scoped>
/*设置走马灯宽度*/
.demonstration {
  width: 100%;
}

/*设置走马灯高度*/
::v-deep .el-carousel__container  {
  position: relative;
  height: 600px;
}


/deep/.el-carousel__indicators--horizontal {
  position: absolute;
  left: auto;
  right: 42%;
  bottom: 10px;
  text-align: right;
}

/deep/ .el-carousel__indicator--horizontal button {
  width: 70px;
  height: 5px;
  background: #ffffff;
  border-radius: 5px;

}

/deep/ .el-carousel__indicator--horizontal.is-active button {
  width: 70px;
  height: 5px;
  background: #ffffff;
  border-radius: 3px;
}

.carousel-title1{
  position: absolute;
  top: 22%;
  left:30%;
  .big-font{
    color: rgb(78, 143, 55);
    font: 80px 思源黑体heavy;

  }
  .small-font{
    color: #2E2921;
    font: 40px 思源黑体heavy;
  }
}

.carousel-title2{
  position: absolute;
  top: 25%;
  left:15%;
  height: 294px;
  width: 671px;
  padding-top: 27px;
  background: url("../../assets/page1/fontback2.png");
}
</style>
