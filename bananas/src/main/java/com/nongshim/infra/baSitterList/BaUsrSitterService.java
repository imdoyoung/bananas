package com.nongshim.infra.baSitterList;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.nongshim.common.util.UtilDateTime;

@Service
public class BaUsrSitterService {

	@Autowired
	private BaUsrSitterDao baUsrSitterDao;
	
	@Autowired
	AmazonS3Client amazonS3Client;
	
	// 시터 리스트 출력
	public List<BaUsrSitterDto>selectList(BaUsrSitterVo baUsrSitterVo){
       return baUsrSitterDao.selectList(baUsrSitterVo);
    }
	
	// 시터 리스트 페이지 페이징
	public int selectOneCount(BaUsrSitterVo baUsrSitterVo) {
		return baUsrSitterDao.selectOneCount(baUsrSitterVo);
	}
	
	// 시터 상세페이지 - 시터 정보 출력
	public BaUsrSitterDto selectOne(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.selectOne(baUsrSitterDto);
	}
	
	// 시터 상세페이지 - 리뷰 리스트 출력
	public List<BaUsrSitterDto>reSelectList(){
	    return baUsrSitterDao.reSelectList();
	}
	
	// 시터 상세페이지 - 리뷰 등록
	public int reInsert(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.reInsert(baUsrSitterDto);
	}
	
	// 시터 상세페이지 - 예약 옵션 리스트 출력
	public List<BaUsrSitterDto>opSelectList(){
	    return baUsrSitterDao.opSelectList();
	}
	
	// sitterDetil에서 booking insert
	public int bookingInsert(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.bookingInsert(baUsrSitterDto);
	}
	
	// sitterDetil에서 bookingOption insert
	public int bookingOptionInsert(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.bookingOptionInsert(baUsrSitterDto);
	}
	
	// baUsrPayment 페이지 booking 테이블 정보 출력
	public BaUsrSitterDto paymentBookingSelectOne(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.paymentBookingSelectOne(baUsrSitterDto);
	};
	
	// baUsrPayment 페이지 option 테이블 정보 출력
	public List<BaUsrSitterDto> paymentOptionSelectList(BaUsrSitterDto baUsrSitterDto){
		return baUsrSitterDao.paymentOptionSelectList(baUsrSitterDto);
	};
	
	// baUsrPayment 페이지 결제정보 update
	public int paymentBookingUpdate(BaUsrSitterDto baUsrSitterDto) {
		return baUsrSitterDao.paymentBookingUpdate(baUsrSitterDto);
	};
	
	// 시터 프로필 사진 업로드
	public int insertUploaded(BaUsrSitterDto baUsrSitterDto, int type) throws Exception {
		// 파일업로드
		for (int i = 0; i < baUsrSitterDto.getUploadFiles().length; i++) {

			// S3
			if (!baUsrSitterDto.getUploadFiles()[i].isEmpty()) {

				String className = baUsrSitterDto.getClass().getSimpleName().toString().toLowerCase();
				String fileName = baUsrSitterDto.getUploadFiles()[i].getOriginalFilename();
				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
				String uuid = UUID.randomUUID().toString();
				String uuidFileName = uuid + "." + ext;
				String pathModule = className;
				String nowString = UtilDateTime.nowString();
				String pathDate = nowString.substring(0, 4) + "/" + nowString.substring(5, 7) + "/"
						+ nowString.substring(8, 10);
				String path = pathModule + "/" + type + "/" + pathDate + "/";
//					String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";

				ObjectMetadata metadata = new ObjectMetadata();
				metadata.setContentLength(baUsrSitterDto.getUploadFiles()[i].getSize());
				metadata.setContentType(baUsrSitterDto.getUploadFiles()[i].getContentType());

				amazonS3Client.putObject("sweetybears", path + uuidFileName,
						baUsrSitterDto.getUploadFiles()[i].getInputStream(), metadata);

				String objectUrl = amazonS3Client.getUrl("sweetybears", path + uuidFileName).toString();
				System.out.println("objectUrl 확인 : " + objectUrl);
				baUsrSitterDto.setfPath(objectUrl);
				baUsrSitterDto.setfOriginalName(fileName);
				baUsrSitterDto.setfUuidName(uuidFileName);
				baUsrSitterDto.setfExt(ext);
				baUsrSitterDto.setfSize(baUsrSitterDto.getUploadFiles()[i].getSize());

				baUsrSitterDto.setfType(type);
				baUsrSitterDto.setfPseq(baUsrSitterDto.getBasiSeq());

				baUsrSitterDao.insertUploaded(baUsrSitterDto);
			}
		}

		return 1;
	}
		
		// file 첨부
//		public int insertUploaded(BaUsrSitterDto baUsrSitterDto) {
//			return baUsrSitterDao.insertUploaded(baUsrSitterDto);
//		};
		


   
}