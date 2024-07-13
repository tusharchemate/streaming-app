package service;

import lombok.RequiredArgsConstructor;
import model.Video;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import repository.VideoRepository;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final S3Service s3Service;
    private final VideoRepository videoRepository;
    public void uploadVideo(MultipartFile multipartFile) {
        // upload to  AWS s3
        // save video data to database
       String videoUrl = s3Service.uploadFile(multipartFile);
       var video = new Video();
       video.setVideoUrl(videoUrl);
       videoRepository.save(video);
    }
}
