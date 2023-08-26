<template>
  <div style="margin-top:100px;text-align: center">
    <Subtitle subtitle="我们的服务" description="超越期望，满足你的每一个需求"/>

    <div>
      <table style="margin: 0px auto;" >
        <tr>
          <td>
              <FlippableCard title="商品售卖" description="我们与农民直接合作，为您提供新鲜、健康的农产品，满足您的需求" icon-class="el-icon-shopping-cart-1" :img="require('@/assets/page1/box1/image1.jpg')"/>
          </td>
          <td>
            <FlippableCard title="需求代理" description="我们将与广泛的供应商网络合作，为您寻找并满足您的农产品需求" icon-class="el-icon-coordinate" :img="require('@/assets/page1/box1/image2.jpg')"/>
          </td>
          <td>
            <FlippableCard title="知识发布" description="我们提供农业知识发布功能，让您能够获取有关农产品生产、种植技术等方面的知识" icon-class="el-icon-notebook-1" :img="require('@/assets/page1/box1/image3.jpg')"/>
          </td>
          <td>
            <FlippableCard title="专家预约" description="我们为您提供专家预约服务，让您能够预约农业领域的专业人士" icon-class="el-icon-chat-line-square" :img="require('@/assets/page1/box1/image4.jpg')"/>
          </td>
        </tr>

      </table>
    </div>
  </div>
</template>

<script>


import Subtitle from "../../components/Subtitle";
import FlippableCard from "../../components/FlippableCard";

export default {
  name: "OurService",
  components:{
    Subtitle,
    FlippableCard
  },
  mounted() {
    // 获取所有的flip-container元素
    const flipContainers = document.querySelectorAll('.flip-container');

    // 遍历每个flip-container元素
    flipContainers.forEach(container => {
      // 监听鼠标悬停事件
      container.addEventListener('mouseover', () => {
        container.classList.add('hover');
      });

      // 监听鼠标移出事件
      container.addEventListener('mouseout', () => {
        container.classList.remove('hover');
      });
    });
  }


}
</script>

<style scoped>



table{
  border-collapse:collapse;
}
table td{
  border:15px solid rgba(255, 255, 255, 0.1);
}







</style>
