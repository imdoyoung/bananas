package com.nongshim.infra.baMypage;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.nongshim.common.util.UtilDateTime;

@Service
public class BaMypageService {

	@Autowired
	BaMypageDao baMypageDao;
	
	@Autowired
	AmazonS3Client amazonS3Client;

	// 이용자 마이페이지

	// 시터 리뷰 리스트
	public List<BaMypageDto> BaMypageReviewSelectList(BaMypageVo baMypageVo) {
		return baMypageDao.BaMypageReviewSelectList(baMypageVo);
	}

	// 장소 리뷰 리스트
	public List<BaMypageDto> BaMypagePlaceSelectList() {
		return baMypageDao.BaMypagePlaceSelectList();
	}

	// 리뷰 selectOne
	public BaMypageDto BaMypageSelectOne(BaMypageDto baMypageDto) {
		return baMypageDao.BaMypageSelectOne(baMypageDto);
	}

	// 시터 리뷰 paging
	public int selectSitterOneCount(BaMypageVo baMypageVo) {
		return baMypageDao.selectSitterOneCount(baMypageVo);
	}

	// 장소 리뷰 paging

	// --

	// 예약 내역 리스트
	public List<BaMypageDto> BaMypageBookingSelectList(BaMypageVo baMypageVo) {
		return baMypageDao.BaMypageBookingSelectList(baMypageVo);
	}

	// 예약 내역 selectOne
	public BaMypageDto BaMypagePriceSelectOne(BaMypageDto baMypageDto) {
		return baMypageDao.BaMypagePriceSelectOne(baMypageDto);
	}

	// 예약 내역 paging
	public int selectMypageBookingCount(BaMypageVo baMypageVo) {
		return baMypageDao.selectMypageBookingCount(baMypageVo);
	}

	// 예약 내역 상세 리스트
	public List<BaMypageDto> BaMypageBookingDetailsSelectList(BaMypageVo baMypageVo) {
		return baMypageDao.BaMypageBookingDetailsSelectList(baMypageVo);
	}

	// 예약 내역 상세 리스트 paging
	public int selectMypageBookingDetailsCount(BaMypageVo baMypageVo) {
		return baMypageDao.selectMypageBookingDetailsCount(baMypageVo);
	}

	// 알림장 보기 (ba_diary 마스터)
	public List<BaMypageDto> BaMypageNoticeSelectList(BaMypageDto baMypageDto) {
		return baMypageDao.BaMypageNoticeSelectList(baMypageDto);
	}

	// 알림장 보기(ba_bookingoption 마스터)
//	public List<BaMypageDto> BaMypageNoticeOptionList(BaMypageDto baMypageDto) {
//		return baMypageDao.BaMypageNoticeOptionList(baMypageDto);
//	}
//	

	// 시터 마이페이지

	// 나의 예약 리스트
	public List<BaMypageDto> sitterPageBookingSelectList(BaMypageVo baMypageVo) {
		return baMypageDao.sitterPageBookingSelectList(baMypageVo);
	}

	// 나의 예약 paging
	public int sitterPageBookingCount(BaMypageVo baMypageVo) {
		return baMypageDao.sitterPageBookingCount(baMypageVo);
	}

	// 페이징 없는 예약 리스트
//	public List<BaMypageDto> BaMypageBookingSelectListAll() {
//		return baMypageDao.BaMypageBookingSelectListAll();
//	}

	// 나의 예약 페이징 없는 리스트(캘린더 용)
	public List<BaMypageDto> sitterPageBookingCalendarSelectList(BaMypageDto baMypageDto) {
		return baMypageDao.sitterPageBookingCalendarSelectList(baMypageDto);
	}

	// 나의 리뷰 리스트
	public List<BaMypageDto> sitterMyReviewList(BaMypageVo baMypageVo) {
		return baMypageDao.sitterMyReviewList(baMypageVo);
	}

	// 나의 리뷰 paging
	public int sitterMyReviewSelectOneCount(BaMypageVo baMypageVo) {
		return baMypageDao.sitterMyReviewSelectOneCount(baMypageVo);
	}

	// 나의 리뷰 자세히 보기 selectOne
	public BaMypageDto sitterMyReviewSelectOne(BaMypageDto baMypageDto) {
		return baMypageDao.sitterMyReviewSelectOne(baMypageDto);
	}

	// 알림장 보기
	public BaMypageDto sitterNoticeSelectOne(BaMypageDto baMypageDto) {
		return baMypageDao.sitterNoticeSelectOne(baMypageDto);
	}

	// 알림장 쓰기(booking 마스터)
	public BaMypageDto sitterNoticeWriteSelectOne(BaMypageDto baMypageDto) {
		return baMypageDao.sitterNoticeWriteSelectOne(baMypageDto);
	}

	// 알림장 쓰기(bookingoption 마스터)
	public List<BaMypageDto> sitterNoticeWriteSelectList(BaMypageDto baMypageDto) {
		return baMypageDao.sitterNoticeWriteSelectList(baMypageDto);
	}

	// 알림장 내용 insert
	public int sitterNoticeInsert(BaMypageDto baMypageDto, int type)throws Exception {
//		baMypageDao.sitterNoticeInsert(baMypageDto);
//		// 파일업로드
//		for (int i = 0; i < baMypageDto.getUploadFiles().length; i++) {
//
//			// S3
//			if (!baMypageDto.getUploadFiles()[i].isEmpty()) {
//
//				String className = baMypageDto.getClass().getSimpleName().toString().toLowerCase();
//				String fileName = baMypageDto.getUploadFiles()[i].getOriginalFilename();
//				String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
//				String uuid = UUID.randomUUID().toString();
//				String uuidFileName = uuid + "." + ext;
//				String pathModule = className;
//				String nowString = UtilDateTime.nowString();
//				String pathDate = nowString.substring(0, 4) + "/" + nowString.substring(5, 7) + "/"
//						+ nowString.substring(8, 10);
//				String path = pathModule + "/" + type + "/" + pathDate + "/";
////						String pathForView = Constants.UPLOADED_PATH_PREFIX_FOR_VIEW_LOCAL + "/" + pathModule + "/" + type + "/" + pathDate + "/";
//
//				ObjectMetadata metadata = new ObjectMetadata();
//				metadata.setContentLength(baMypageDto.getUploadFiles()[i].getSize());
//				metadata.setContentType(baMypageDto.getUploadFiles()[i].getContentType());
//
//				amazonS3Client.putObject("sweetybears", path + uuidFileName, baMypageDto.getUploadFiles()[i].getInputStream(), metadata);
//
//				String objectUrl = amazonS3Client.getUrl("sweetybears", path + uuidFileName).toString();
//				System.out.println("objectUrl 확인 : " + objectUrl);
//				baMypageDto.setfPath(objectUrl);
//				baMypageDto.setfOriginalName(fileName);
//				baMypageDto.setfUuidName(uuidFileName);
//				baMypageDto.setfExt(ext);
//				baMypageDto.setfSize(baMypageDto.getUploadFiles()[i].getSize());
//
//				baMypageDto.setfType(type);
//				baMypageDto.setfRegSeq(baMypageDto.getBadiSeq());
//
//				baMypageDao.insertUploaded(baMypageDto);
//			}
//		}
//		return 1;
		return baMypageDao.sitterNoticeInsert(baMypageDto);
	}

	// 알림장 baboDiaryNy 0 -> 1 update
	public int sitterNoticeUpdate(BaMypageDto baMypageDto) {
		return baMypageDao.sitterNoticeUpdate(baMypageDto);
	}

	// 알림장 내용 selectOne
	public BaMypageDto sitterNoticeContentSelectOne(BaMypageDto baMypageDto) {
		return baMypageDao.sitterNoticeContentSelectOne(baMypageDto);
	}

}
