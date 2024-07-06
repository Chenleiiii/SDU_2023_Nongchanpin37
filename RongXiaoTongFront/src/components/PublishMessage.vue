<template>
  <div class="publish-message">
    <el-form ref="form" :model="form" label-width="70px" style="margin-top:50px;">
      <el-form-item label="添加图片">
        <el-upload
          class="orders-img_el_upload"
          :action="upurl"
          :headers="upheaders"
          :limit="3"
          list-type="picture-card"
          :on-change="handleChange"
          :on-preview="handlePreview"
          :on-remove="handleRemove"
          :on-success="handleSuccess"
          :on-error="handleError"
          :file-list="fileList"
          :class="{ disUoloadSty: noneBtnImg }"
          ref="upload">
          <span class="orders-img_el_upload_btn" @click.stop="submitUpload">添加图片</span>
        </el-upload>
      </el-form-item>
      <el-form-item label="标题">
        <el-input v-model="form.title"  style="width:800px;" placeholder="添加标题"></el-input>
      </el-form-item>
      <el-form-item label="内容">
        <el-input type="textarea"  style="width:800px;" v-model="form.content" placeholder="添加内容"></el-input>
      </el-form-item>
      <el-form-item label="定价">
        <el-input v-model="form.price" style="width:100px;"></el-input>
      </el-form-item>
    </el-form>
    <el-button type="success" :disabled="isDisabled" @click="publishClick">发布信息</el-button>
  </div>
</template>

<script>
import { addOrder } from "../api/order";
export default {
  name: "PublishMessage",
  data() {
    return {
      dialogImageUrl: "",
      dialogVisible: false,
      showBtnImg: true,
      noneBtnImg: false,
      limitCountImg: 3,
      upurl: this.$store.state.fileUploadRoad + "/file/upload/order",
      upheaders: {
        Authorization: window.localStorage.token,
      },
      fileList: [],
      
      imgurl: "",
      
      form:{
        title: "",
        content: "",
        price: "",
        picture: "",
      }
    };
  },
  props: {
    ctype: {
      type: String,
    },
  },
  computed: {
    isDisabled() {
      if(this.ctype === 'needs'){
        return this.form.title == "" || this.form.content == "";
      }else{
        return this.form.title == "" || this.form.content == "" || this.form.price == "";
      }
    },
  },
  methods: {
    handleError(err, file, fileList) {
      this.$message({
        message: "上传失败！",
        type: "success",
      });
      console.log(err);
    },
    handleSuccess(response, file, fileList) {
      if (file.response.flag == true) {
        this.fileList = fileList;
        this.form.picture = file.response.data;
        if (fileList.length >= 3) {
          this.uploadDisabled = true;
        }
        alert(file.response.message);
      } else {
        alert(file.response.data);
      }
    },
    handleChange(file, fileList) {
      this.noneBtnImg = fileList.length >= this.limitCountImg;
    },
    handleRemove(file, fileList) {
      this.noneBtnImg = fileList.length >= this.limitCountImg;
      this.fileList.pop();
      // this.form.photo = "";
      this.uploadDisabled = false;
    },
    handlePreview(file) {
      this.dialogImageUrl = file.url;
      this.dialogVisible = true;
    },
    submitUpload() {
      this.$refs.upload.submit();
    },
    publishClick() {
      if ((this.form.picture == "")&&(this.ctype !== 'needs')) {
        alert("图片不能为空");
      } else {
        addOrder({
          title: this.form.title,
          content: this.form.content,
          price: this.form.price,
          type: this.ctype,
          picture: this.form.picture,
        }).then((res) => {
          if (res.flag == true) {
            this.$message.success(res.message);
            this.$router.push("/home/user/published" + this.ctype);
          } else {
            this.$message.error(res.data);
          }
        })
        .catch((err) => {
          console.log("添加失败");
        });
      }
    },
  },
};
</script>

<style lang="less" scoped>
.disUoloadSty .el-upload--picture-card {
  display: none; /* 上传按钮隐藏 */
}
.publish-message {
  width: 1100px;
  margin: 20px auto;
  padding: 10px 20px;
  .orders-img_el_upload {
    width: 1000px;
    float: left;
    height: 148px;
    .el-upload {
      //   width: 50px;
      //   height: 20px;
      border: 1px dashed #d9d9d9;
      border-radius: 6px;
      cursor: pointer;
      position: relative;
      overflow: hidden;
      &:hover {
        border-color: #409eff;
      }
      .el-upload__input {
        position: absolute;
        left: -1000px;
      }
    }
  }
  .title {
    width: 1100px;
    height: 60px;
    margin-top: 50px;
    font-size: 22px;
    outline: none;
    border: none;
    border-bottom: 1px solid black;
  }
  .content {
    font-size: 18px;
    width: 1200px;
    resize: none;
    outline: none;
    border: none;
    border-bottom: 1px solid black;
  }
  .price {
    font-size: 20px;
    .price-input {
      width: 100px;
      outline: none;
      border: none;
      margin: 0 20px;
    }
  }
  .el-button {
    width: 120px;
    height: 50px;
    margin-top: 20px;
    margin-left: 540px;
    font-size: 20px;
  }
}
</style>