<template>
  <div class="details-box2">
    <smart-match-user></smart-match-user>
  </div>

</template>

<script>
import { selectRecommned } from "../../api/finance";
import SmartMatchUser from '../../components/SmartMatchUser.vue';
export default {
  data() {
    return {
      intentionData:{
        amount:'',
        application:'',
        item:'',
        repaymentPeriod:'',
        address:''
      },
      allRecommendData:[],
    };
  },
  filters: {
    changeTime(time) {
      return time.slice(0, 10);
    },
  },
  components: { SmartMatchUser },
  props: {
    ctype: {
      type: String,
    },
    cdesciibe: {
      type: String,
    },
  },
  methods: {
    getAllRecommned(){
      selectRecommned().then(res=>{
        if(res.flag==true){
console.log('ressss',res)
        this.allRecommendData = res.data
        }else{
           this.$message.error('您未登录，请先登录')
        }

      }).catch(err=>{
        console.log(err)

      })
    },

  },
  created() {
    // this.getAllRecommned()
    this.form = Object.assign({},{...JSON.parse(localStorage.getItem('financeObj'))})
  }
};
</script>

<style lang="less" scoped>
.add-address {
  width: 1100px;
  margin: 10px auto;
  float: left;
  padding: 20px;
  background: #fff;
  min-height: 100%;
  .title {
    border-bottom: 1px solid #f2f2f2;
    padding: 10px 0px;
    font-size: 18px;
  }
}
.details-box2 {
  width: 1100px;
  margin: 10px auto;
  background: #fff;
  min-height: 100%;
  height: auto;

  img {
    width: 300px;
    height: 300px;
    float: left;
    margin-right: 20px;
  }
  .title{
    font-size: 18px;
    line-height: 40px;
  }
  .introduce{
    line-height: 25px;
    max-height: 100px;
  }
  .item-content{
    display: flex;
    flex-direction: row;
    justify-content: flex-start;
    align-items: center;
    height: 30px;
    line-height: 30px;
    .item-title{
      font-weight: bold;
    }
    .item-text{

    }
  }
  .info {
    position: relative;
    width: 340px;
    height: 300px;
    float: left;
    .title {
      font-size: 22px;
      font-weight: bold;
    }
    .content {
      height: 100px;
    }
    .price {
      color: red;
      font-size: 25px;
      font-weight: bold;
    }
    .time {
      margin-top: 10px;
      color: #999;
      .createtime {
        float: left;
      }
      .updatetime {
        float: right;
      }
    }
  }
  .operation {
    position: absolute;
    bottom: 0;
    margin-top: 20px;
    .like,
    .collection,
    .comment {
      display: inline-block;
      width: 30px;
      margin-right: 30px;
      img {
        margin: 0;
        width: 20px;
        height: 20px;
        border-radius: 6px;
      }
    }
  }
  .add-shopcart {
    position: absolute;
    right: 20px;
    bottom: 5px;
  }
}
.btn-style{
  display: flex;
  justify-content: center;

}
.goods-box {
  background-color: #f9f9f9;
  width: 1100px;
  margin: 0 auto;
  .goods {
    float: left;
    text-align: center;
    width: 200px;
    height: 220px;
    margin-top: 15px;
    border-radius: 20%;
    padding: 15px;
    background-color: rgb(255, 255, 255);
    border: 1px solid #d3d3d3;
    position: relative;
    // margin: 0 auto;
    cursor: pointer;
    .goods-img {
      float: left;
      width: 80px;
      height: 80px;
      margin-right: 10px;
      border-radius: 100%;

      position: absolute;top:10px;left:60px;

    }
    .info {
      width: 180px;
      top: 80px;
      // float: left;
      .initiator1 {
        color: #666;
        // position: absolute;top:80px;
      }
      // .initiator2 {
      //   color: #666;
      //   position: absolute;top:90px;left:55px;
      // }
      // .initiator3 {
      //   color: #666;
      //   position: absolute;top:100px;left:55px;
      // }
      // .initiator4 {
      //   color: #666;
      //   position: absolute;top:115px;left:55px;
      // }

    }
  }
}
</style>
