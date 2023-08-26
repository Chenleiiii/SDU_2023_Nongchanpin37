<template>
  <div class="user-avatar">
    <img :src="$store.state.imgShowRoad + '/file/' + cUserAvatar" alt="" class="avatar"/>
    <el-form label-width="100px">
      <el-upload
        class="user-avatar_el_upload"
        :action="upurl"
        :headers="upheaders"
        :limit="1"
        list-type="picture-card"
        :on-change="handleChange"
        :on-preview="handlePreview"
        :on-remove="handleRemove"
        :on-success="handleSuccess"
        :on-error="handleError"
        :file-list="fileList"
        :class="{ disUoloadSty: noneBtnImg }"
        ref="upload">
        
        <span class="user-avatar_el_upload_btn" @click.stop="submitUpload">上传头像</span>
      </el-upload>
    </el-form>
  </div>
</template>

<script>
export default {
  data() {
    return {
      dialogImageUrl: "",
      dialogVisible: false,
      showBtnImg: true,
      noneBtnImg: false,
      limitCountImg: 1,
      upurl: this.$store.state.fileUploadRoad + "/file/upload/avatar",
      upheaders: {
        Authorization: window.localStorage.token,
      },
      fileList: [],
      imgurl: "",
    };
  },
  props: {
    cUserAvatar: {
      type: String,
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
        this.cUserAvatar = file.response.data;
        console.log("头像：：：")
        console.log(file.response.data)
        console.log(fileList)
        if (fileList.length >= 1) {
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
      this.fileList = [];
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
  },
};
</script>

<style lang="less" scoped>
.disUoloadSty .el-upload--picture-card {
  display: none; /* 上传按钮隐藏 */
}
.user-avatar {
  width: 1200px;
  height: 150px;
  .avatar {
    float: left;
    width: 148px;
    height: 148px;
    border-radius: 50%;
  }
  .user-avatar_el_upload {
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
}
</style>