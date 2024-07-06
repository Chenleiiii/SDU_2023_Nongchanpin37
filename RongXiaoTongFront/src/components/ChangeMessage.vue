<template>
  <div class="changemessage">
    <div class="modify-text" @click="dialogFormVisible = true">修改</div>
    <el-dialog title="商品信息" :visible.sync="dialogFormVisible" class="modify-message">
      <el-form label-width="100px">
        <el-form-item label="商品图片" :label-width="formLabelWidth">
          <img
            :src="$store.state.imgShowRoad + '/file/' + cupdateGoodInfo.picture"
            alt=""
            class="order-img"/>
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
            ref="upload"
          >
            <span class="orders-img_el_upload_btn" @click.stop="submitUpload"
              >上传图片</span
            >
          </el-upload>
        </el-form-item>
      </el-form>
      <el-form :model="form">
        <el-form-item label="商品标题" :label-width="formLabelWidth">
          <el-input
            v-model="cupdateGoodInfo.title"
            autocomplete="off"
            class="title"
          ></el-input>
        </el-form-item>
        <el-form-item label="商品内容" :label-width="formLabelWidth">
          <textarea
            v-model="cupdateGoodInfo.content"
            autocomplete="off"
            class="content"
          ></textarea>
        </el-form-item>
        <el-form-item label="商品价格" :label-width="formLabelWidth">
          <el-input v-model="cupdateGoodInfo.price" autocomplete="off" class="price"></el-input>
          元
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogFormVisible = false">取 消</el-button>
        <el-button type="success" @click.stop="changeMessageClick"
          >确 定</el-button
        >
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { updateOrderById } from "../api/order";
export default {
  inject: ["reload"],
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
      form: {},
      fileList: [],
      picture: "",
      dialogFormVisible: false,
      formLabelWidth: "120px",
    };
  },
  props: {
    cupdateGoodInfo: {
      type: Object,
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
        this.cupdateGoodInfo.picture = file.response.data;
        if (fileList.length >= 3) {
          this.uploadDisabled = true;
        }
        alert(file.response.message);
      } else alert(file.response.data);
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
    changeMessageClick() {
      this.dialogFormVisible = false;
      updateOrderById({
        order_id: this.$store.state.changedOrderId,
        title: this.cupdateGoodInfo.title,
        content: this.cupdateGoodInfo.content,
        price: this.cupdateGoodInfo.price,
        picture: this.cupdateGoodInfo.picture,
      })
        .then((res) => {
          if (res.flag == true) {
            this.reload();
            alert(res.message);
          } else {
            alert(res.data);
            this.reload();
          }
        })
        .catch((err) => {
          alert("修改失败");
        });
    },
  },
};
</script>

<style lang="less" scoped>
.changemessage {
  // margin-top: -10px;
  .modify-text {
    height: 25px;
    cursor: pointer;
    margin-right: 10px;
    color: #67C23A;
    &:hover{
      color: #035D1C;
    }
  }
  .el-dialog {
    width: 600px;
    .order-img {
      width: 148px;
      height: 148px;
      border-radius: 6px;
    }
    .orders-img_el_upload {
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
      width: 400px;
    }
    .content {
      width: 400px;
      height: 150px;
      resize: none;
      outline: none;
      line-height: 1.5;
      border: 1px solid #dcdfe6;
    }
    .price {
      width: 100px;
    }
  } // width: 1200px;
}
</style>