<template>
  <div class="flip-container">
    <div class="flipper">
      <div class="front">
        <img :src="this.img" style=" border-radius: 10px;filter: brightness(50%);" alt="">
        <i :class="this.iconClass+' little-logo'"></i>
        <div class="title">{{this.title}}</div>
      </div>
      <div class="back">
        <img :src="img" style="opacity: 0.5; border-radius: 10px;" alt="">
        <div class="description">{{this.description}}</div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "FlippableCard",
  props:{
    title: {
      type: String,
    },
    description: {
      type: String,
    },
    iconClass:{
      type:String
    },
    img:{
      type: String,
      required: true,
    }
  },
}
</script>

<style scoped>

.little-logo{
  position: absolute;
  top: 30%;
  left: 30%;
  color: #97ff92;
  font-size: 130px;
}

.title{
  position: absolute;
  top: 60%;
  left: 25%;
  font-size: 40px;
  color: #97ff92;
  font-family: 微软雅黑;
  font-weight: bold;
}

.description{
  position: absolute;
  top: 40%;
  left: 5%;
  height: 200px;
  padding: 1px 15px;
  color: #2a2a2a;
  font-size: 20px;
  font-weight: bold;
}

/* entire container, keeps perspective */
.flip-container {
  perspective: 1000px;
}
/* flip the pane when hovered */
.flip-container:hover .flipper, .flip-container.hover .flipper {
  animation: flip 1s forwards;
}




.flip-container, .front, .back {
  width: 320px;
  height: 510px;
}

/* flip speed goes here */
.flipper {
  /*transition: 0.6s;*/
  transform-style: preserve-3d;
  /*position: relative;*/
}

/* hide back of pane during swap */
.front, .back {
  backface-visibility: hidden;
  position: absolute;
  top: 0;
  left: 0;
}

/* front pane, placed above back */
.front {
  z-index: 2;
}

img{
  box-shadow: 0px 0px 10px black;
}

/* back, initially hidden pane */
.back {
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
