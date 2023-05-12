<template>
	<view>
		<view class="rotation_map">
			<swiper class="swiper" indicator-dots="true" autoplay="true" interval="2000" duration="500">
				<swiper-item>
					<image src="https://img.zcool.cn/community/01fe0b599e8185a80121ad7ba37e3a.jpg@1280w_1l_2o_100sh.jpg"></image>
				</swiper-item>
				<swiper-item>
					<image src="https://img95.699pic.com/photo/50128/5802.jpg_wh860.jpg"></image>
				</swiper-item>
				<swiper-item>
					<image src="https://picb.zhimg.com/v2-6f2d6ba75383e740ec0452067c4f0c70_r.jpg"></image>
				</swiper-item>
			</swiper>	
		</view>
		
		<!-- card -->
		<el-col class="cardContent"  v-for="(item,index) in today" >
			<navigator url="../translate/translate" @click="handleMessage(item)">
				<el-card :body-style="{ padding: '0px' }">
				  <image :src="item.image" class="image" ></image>
				  <div class="innerContent" style="padding: 14px;">
					<span>{{item.title}}</span>
					<span style="float: right;"><image src="../../static/icon/dianzan1.png"></image>{{item.likeNum}}</span>
					<div class="bottom">
					  <view class="text">{{item.chinese}}</view>
					</div>
				  </div>
				</el-card>
			</navigator>
			
		</el-col>
		<view class="footBottom">已经到底了，请上拉刷新</view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				 pageNum:1,
				 today:[]
					
			}
		},
		components:{
		},
		onLoad() {
			this.$request.get("/comp/getComp",{
				"type":"今天",
				"pageNum":this.pageNum
			}).then(res=>{
				this.today=res.data;
				console.log(this.today)
			});
			
		},
		onReachBottom(){
			this.pageNum=this.pageNum+1;
			this.$request.get("/comp/getComp",{
				"type":"今天",
				"pageNum":this.pageNum
			}).then(res=>{
				// this.composition=res.data;
				this.today.push(...res.data)
			});
		},
		methods: {
			handleMessage(item){
				//注意：如果用push则不能返回上一个页面
				this.$router.replace({
					path:"../translate/translate",
					query:{"translate":item}
				})
			},
		}
	}
</script>

<style lang="less" scoped>	  
	.rotation_map{
		.swiper{
			image{
				margin: 10rpx 35rpx;
				height: 500rpx;
				width: 90%;
			}
		}
	}
	.cardContent{
		margin-top: 25rpx;
		margin-left: 2%;
		width: 96%;
		.image {
			height: 450rpx;
		  width: 100%;
		  display: block;
		}
		.innerContent{
			image{
				margin-right: 30rpx;
				height: 50rpx;
				width: 50rpx;
				border-radius: 50%;
			}
		}
		.bottom {
		  margin-top: 13px;
		  line-height: 16px;
		    .text {
		      	color: #999;
		      	font-size: 14px;
		      	display: -webkit-box;
		      	overflow: hidden;
		      	text-overflow: ellipsis;
		      	word-wrap: break-word;
		      	white-space: normal !important;
		      	-webkit-line-clamp: 2;
		      	-webkit-box-orient: vertical;
		    }
		}
	}
	
	.footBottom{
		text-align: center;
		font-size: 13px;
		color: #999;
	}
	
</style>
