<template>
  <div class="publish-message">
    <el-form label-width="100px" :model="form" style="margin-top:50px;">
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
        <el-input v-model="form.title" placeholder="添加标题"></el-input>
      </el-form-item>
      <el-form-item label="内容">
        <el-input type="textarea" v-model="form.content" placeholder="添加内容"></el-input>
      </el-form-item>
    </el-form>
    <div style="display:flex;justify-content:center;">
      <el-button type="success" :disabled="isDisabled" @click="publishClick">发布信息</el-button>
    </div>
  </div>
</template>

<script>
import { addKnowledge } from "../api/knowledge";
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
      // picPath: "",
      imgurl: "",
      // title: "",
      // content: "",
      form:{
        title:'',
        content:'',
        picPath:''
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
      return this.form.title == "" || this.form.content == ""
    },
    isActive() {},
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
        this.form.picPath = file.response.data;
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
      addKnowledge({
        title: this.form.title,
        content: this.form.content,
        picPath: this.form.picPath,
      })
        .then((res) => {
          if (res.flag == true) {
            alert(res.message);
            this.$router.push("/home/user/published" + this.ctype);
          } else {
            alert(res.message);
          }
        })
        .catch((err) => {
          console.log("添加失败");
        });
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
  background: #fff;
  // min-height: 100%;
  // height: auto;
  .orders-img_el_upload {
    width: 1000px;
    
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
}
</style>