package com.java.dto;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GalleryList {
	private String galContentId,galContentTypeId,galTitle,galWebImageUrl,galCreatedtime,galModifiedtime,
	galPhotographyMonth,galPhotographyLocation,galPhotographer,galSearchKeyword;
}
