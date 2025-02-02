package com.nongshim.infra.baPlace;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.nongshim.common.util.UtilDateTime;
import com.nongshim.infra.baSitterList.BaUsrSitterDto;

@Service
public class BaPlaceService {
	
	@Autowired
	BaPlaceDao baPlaceDao;
	
	@Autowired
	AmazonS3Client amazonS3Client;

	public List<BaPlaceDto> placeSelectList(BaPlaceVo baPlaceVo) {
		return baPlaceDao.placeSelectList(baPlaceVo);
	}
	
	// placeSelectOneCount - 페이징
	public int placeSelectOneCount(BaPlaceVo baPlaceVo) {
		return baPlaceDao.placeSelectOneCount(baPlaceVo);
	}
	
	// placeDetailList - 장소추천 세부리스트
	public List<BaPlaceDto> placeDetailList(BaPlaceDto baPlaceDto) {
		return baPlaceDao.placeDetailList(baPlaceDto);
	}
	
	// PlaceReviewInsert - 리뷰 insert
//	public int PlaceReviewInsert(BaPlaceDto baPlaceDto) {
//		return baPlaceDao.PlaceReviewInsert(baPlaceDto);
//	}
	
	// 시터 프로필 사진 업로드
	public int insertUploaded(BaPlaceDto baPlaceDto, int type) throws Exception {
		// 파일업로드
		for (int i = 0; i < baPlaceDto.getUploadFiles().length; i++) {

			// S3
			if (!baPlaceDto.getUploadFiles()[i].isEmpty()) {

				String className = baPlaceDto.getClass().getSimpleName().toString().toLowerCase();
				String fileName = baPlaceDto.getUploadFiles()[i].getOriginalFilename();
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
				metadata.setContentLength(baPlaceDto.getUploadFiles()[i].getSize());
				metadata.setContentType(baPlaceDto.getUploadFiles()[i].getContentType());

				amazonS3Client.putObject("lovelybears", path + uuidFileName,
						baPlaceDto.getUploadFiles()[i].getInputStream(), metadata);

				String objectUrl = amazonS3Client.getUrl("lovelybears", path + uuidFileName).toString();
				System.out.println("objectUrl 확인 : " + objectUrl);
				baPlaceDto.setfPath(objectUrl);
				baPlaceDto.setfOriginalName(fileName);
				baPlaceDto.setfUuidName(uuidFileName);
				baPlaceDto.setfExt(ext);
				baPlaceDto.setfSize(baPlaceDto.getUploadFiles()[i].getSize());

				baPlaceDto.setfType(type);
				baPlaceDto.setfRegIp(baPlaceDto.getBaplSeq());

				baPlaceDao.insertUploaded(baPlaceDto);
			}
		}

		return 1;
	}
	
}
