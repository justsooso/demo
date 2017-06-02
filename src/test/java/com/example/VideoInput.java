////package com.example;
//
//import com.sun.jna.Native;
//import com.sun.jna.Pointer;
//import com.sun.jna.WString;
//import com.sun.jna.ptr.ByReference;
//import com.sun.jna.ptr.FloatByReference;
//import com.sun.jna.ptr.IntByReference;
//import com.sun.jna.win32.StdCallLibrary;
//
//public interface VideoInput extends StdCallLibrary {
//	VideoInput INSTANCE = (VideoInput) Native.loadLibrary("VideoInput",
//			VideoInput.class);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Initialize, Release
//	// //////////////////////////////////////////////////////////////////////
//
//	public int CreateVideoInput();
//
//	public boolean ReleaseVideoInput(int hVideoInput);
//
//	public boolean SetRegInfo(int hVideoInput, WString szRegInfo);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Open, Close
//	// //////////////////////////////////////////////////////////////////////
//
//	public int GetDeviceIndex(int hVideoInput);
//
//	public int GetDeviceCount(int hVideoInput);
//
//	public boolean GetDeviceName(int hVideoInput, int nDeviceIndex,
//			Pointer szDeviceName, int nNameSize);
//
//	public boolean OpenDevice(int hVideoInput, int nDeviceIndex);
//
//	public int OpenDeviceName(int hVideoInput, WString szDeviceName);
//
//	public boolean OpenImageFile(int hVideoInput, WString szFileName);
//
//	public boolean CloseDevice(int hVideoInput, int nDeviceIndex);
//
//	public boolean CloseImageFile(int hVideoInput);
//
//	public boolean IsDeviceOpened(int hVideoInput, int nDeviceIndex);
//
//	public boolean IsImageFileOpened(int hVideoInput);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Device Formats
//	// //////////////////////////////////////////////////////////////////////
//
//	public int GetDeviceFormatCount(int hVideoInput, int nDeviceIndex);
//
//	public boolean GetDeviceFormat(int hVideoInput, int nDeviceIndex,
//			int nFormatIndex, IntByReference pWidth, IntByReference pHeight,
//			Pointer szType, int nTypeSize);
//
//	public boolean GetDeviceFormatName(int hVideoInput, int nDeviceIndex,
//			int nFormatIndex, Pointer szFormatName, int nNameSize);
//
//	public boolean SetDeviceFormat(int hVideoInput, int nDeviceIndex,
//			int nWidth, int nHeight, WString szType);
//
//	public boolean SetDeviceFormatIndex(int hVideoInput, int nDeviceIndex,
//			int nFormatIndex);
//
//	public boolean SetDeviceFormatName(int hVideoInput, int nDeviceIndex,
//			WString szFormatName);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Start, Stop
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean StartPlayDevice(int hVideoInput, int nDeviceIndex);
//
//	public boolean StopPlayDevice(int hVideoInput, int nDeviceIndex);
//
//	public boolean IsDevicePlaying(int hVideoInput, int nDeviceIndex);
//
//	public boolean StartPlayImageFile(int hVideoInput);
//
//	public boolean StopPlayImageFile(int hVideoInput);
//
//	public boolean IsImageFilePlaying(int hVideoInput);
//
//	public boolean SetDeviceStopOnChange(int hVideoInput, boolean bStopOnChange);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Preview
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetPreviewWindow(int hVideoInput, int hWnd);
//
//	public int GetPreviewWindow(int hVideoInput);
//
//	public boolean GetDisplayRect(int hVideoInput, IntByReference pX,
//			IntByReference pY, IntByReference pW, IntByReference pH);
//
//	public boolean SetFastPreview(int hVideoInput, boolean bPreview);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Grab
//	// //////////////////////////////////////////////////////////////////////
//
//	public Pointer GrabToBase64(int hVideoInput, WString szFileExt);
//
//	public boolean GrabToFile(int hVideoInput, WString szFileName);
//
//	public boolean GrabToPdf(int hVideoInput, WString szFileName,
//			WString szTitle, WString szAuthor, WString szKeyword,
//			WString szSubject, WString szCreator);
//
//	public boolean SetJpegQuality(int hVideoInput, float nJpegQuality);
//
//	public boolean SetGrabbedDPI(int hVideoInput, float nDpiX, float nDpiY);
//
//	public boolean ResizeGrabbedFile(int hVideoInput, WString szFileIn,
//			WString szFileOut, int nWidth, int nHeight, boolean bKeepDpi);
//
//	public boolean JpegToPdf(int hVideoInput, WString szFileIn,
//			WString szFileOut, WString szTitle, WString szAuthor,
//			WString szKeyword, WString szSubject, WString szCreator);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Property
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean ShowDevicePages(int hVideoInput, int nDeviceIndex);
//
//	public boolean ShowImageFilePages(int hVideoInput);
//
//	public boolean SetDeviceFOV(int hVideoInput, int nDeviceIndex, float nFovX,
//			float nFovY);
//
//	public boolean GetDeviceFOV(int hVideoInput, int nDeviceIndex,
//			FloatByReference pFovX, FloatByReference pFovY);
//
//	public boolean GetDeviceDPI(int hVideoInput, int nDeviceIndex,
//			FloatByReference pDpiX, FloatByReference pDpiY);
//
//	public boolean SetImageFileFOV(int hVideoInput, float nFovX, float nFovY);
//
//	public boolean GetImageFileFOV(int hVideoInput, FloatByReference pFovX,
//			FloatByReference pFovY);
//
//	public boolean GetImageFileDPI(int hVideoInput, FloatByReference pDpiX,
//			FloatByReference pDpiY);
//
//	// //////////////////////////////////////////////////////////////////////
//	// ColorMode
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetColorMode(int hVideoInput, int nColorMode);
//
//	public int GetColorMode(int hVideoInput);
//
//	public boolean SetColorPreview(int hVideoInput, boolean bPreview);
//
//	public boolean GetColorPreview(int hVideoInput);
//
//	public boolean SetColorSpace(int hVideoInput, int nColorSpace);
//
//	public int GetColorSpace(int hVideoInput);
//
//	public boolean SetColorChannel(int hVideoInput, int nColorChannel);
//
//	public int GetColorChannel(int hVideoInput);
//
//	public boolean SetBinarizeMode(int hVideoInput, int nBinarizeMode);
//
//	public int GetBinarizeMode(int hVideoInput);
//
//	public boolean SetBinarizeAdaptive(int hVideoInput, float nRate, int nX,
//			int nY, int nLow, int nHigh);
//
//	public boolean GetBinarizeAdaptive(int hVideoInput, FloatByReference pRate,
//			IntByReference pX, IntByReference pY, IntByReference pLow,
//			IntByReference pHigh);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Rotate and Flip
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetDeviceRotate(int hVideoInput, int nDeviceIndex, int nAngle);
//
//	public int GetDeviceRotate(int hVideoInput, int nDeviceIndex);
//
//	public boolean SetImageFileRotate(int hVideoInput, int nAngle);
//
//	public int GetImageFileRotate(int hVideoInput);
//
//	public boolean SetDeviceFlipX(int hVideoInput, int nDeviceIndex,
//			boolean bFlipX);
//
//	public boolean SetDeviceFlipY(int hVideoInput, int nDeviceIndex,
//			boolean bFlipY);
//
//	public boolean GetDeviceFlipX(int hVideoInput, int nDeviceIndex);
//
//	public boolean GetDeviceFlipY(int hVideoInput, int nDeviceIndex);
//
//	public boolean SetImageFileFlipX(int hVideoInput, boolean bFlipX);
//
//	public boolean SetImageFileFlipY(int hVideoInput, boolean bFlipY);
//
//	public boolean GetImageFileFlipX(int hVideoInput);
//
//	public boolean GetImageFileFlipY(int hVideoInput);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Deskew
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetDeviceDeskew(int hVideoInput, int nDeviceIndex,
//			boolean bDeskew);
//
//	public boolean GetDeviceDeskew(int hVideoInput, int nDeviceIndex);
//
//	public boolean SetImageFileDeskew(int hVideoInput, boolean bDeskew);
//
//	public boolean GetImageFileDeskew(int hVideoInput);
//
//	public boolean SetDeskewPreview(int hVideoInput, boolean bPreview);
//
//	public boolean GetDeskewPreview(int hVideoInput);
//
//	public boolean SetDeskewCrop(int hVideoInput, boolean bCrop);
//
//	public boolean GetDeskewCrop(int hVideoInput);
//
//	public boolean SetDeskewStamp(int hVideoInput, boolean bStamp);
//
//	public boolean GetDeskewStamp(int hVideoInput);
//
//	// //////////////////////////////////////////////////////////////////////
//	// SrcRect, DstRect, MaskRect
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetDeviceSrcRect(int hVideoInput, int nDeviceIndex,
//			float nX, float nY, float nW, float nH);
//
//	public boolean SetDeviceDstRect(int hVideoInput, int nDeviceIndex,
//			float nX, float nY, float nW, float nH);
//
//	public boolean SetDeviceMaskRect(int hVideoInput, int nDeviceIndex,
//			float nX, float nY, float nW, float nH);
//
//	public boolean GetDeviceSrcRect(int hVideoInput, int nDeviceIndex,
//			FloatByReference pX, FloatByReference pY, FloatByReference pW,
//			FloatByReference pH);
//
//	public boolean GetDeviceDstRect(int hVideoInput, int nDeviceIndex,
//			FloatByReference pX, FloatByReference pY, FloatByReference pW,
//			FloatByReference pH);
//
//	public boolean GetDeviceMaskRect(int hVideoInput, int nDeviceIndex,
//			FloatByReference pX, FloatByReference pY, FloatByReference pW,
//			FloatByReference pH);
//
//	public boolean SetImageFileSrcRect(int hVideoInput, float nX, float nY,
//			float nW, float nH);
//
//	public boolean SetImageFileDstRect(int hVideoInput, float nX, float nY,
//			float nW, float nH);
//
//	public boolean SetImageFileMaskRect(int hVideoInput, float nX, float nY,
//			float nW, float nH);
//
//	public boolean GetImageFileSrcRect(int hVideoInput, FloatByReference pX,
//			FloatByReference pY, FloatByReference pW, FloatByReference pH);
//
//	public boolean GetImageFileDstRect(int hVideoInput, FloatByReference pX,
//			FloatByReference pY, FloatByReference pW, FloatByReference pH);
//
//	public boolean GetImageFileMaskRect(int hVideoInput, FloatByReference pX,
//			FloatByReference pY, FloatByReference pW, FloatByReference pH);
//
//	public boolean ZoomDeviceDstRect(int hVideoInput, int nDeviceIndex,
//			float nScaleX, float nScaleY);
//
//	public boolean MoveDeviceDstRect(int hVideoInput, int nDeviceIndex,
//			float nOffsetX, float nOffsetY);
//
//	public boolean ZoomImageFileDstRect(int hVideoInput, float nScaleX,
//			float nScaleY);
//
//	public boolean MoveImageFileDstRect(int hVideoInput, float nOffsetX,
//			float nOffsetY);
//
//	// //////////////////////////////////////////////////////////////////////
//	// NICapUSB
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetAppendMac(int hVideoInput, boolean bAppendMac);
//
//	public boolean CheckAppendedMac(int hVideoInput, WString szFileName);
//
//	public boolean CheckDeviceMac(int hVideoInput, int nDeviceIndex,
//			WString szMac);
//
//	public boolean TickDeviceAutoFocus(int hVideoInput, int nDeviceIndex);
//
//	public boolean SetDeviceFocus(int hVideoInput, int nDeviceIndex,
//			int nFocusVal);
//
//	public boolean GetDeviceFocus(int hVideoInput, int nDeviceIndex,
//			IntByReference nFocusVal, IntByReference nFocusMin,
//			IntByReference nFocusMax);
//
//	public boolean SetDeviceAutoFocus(int hVideoInput, int nDeviceIndex,
//			boolean bAutoFocus);
//
//	public boolean GetDeviceAutoFocus(int hVideoInput, int nDeviceIndex);
//
//	public boolean SetDeviceExposure(int hVideoInput, int nDeviceIndex,
//			int nExpVal);
//
//	public boolean GetDeviceExposure(int hVideoInput, int nDeviceIndex,
//			IntByReference nExpVal, IntByReference nExpMin,
//			IntByReference nExpMax);
//
//	public boolean SetDeviceAutoExposure(int hVideoInput, int nDeviceIndex,
//			boolean bAutoExp);
//
//	public boolean GetDeviceAutoExposure(int hVideoInput, int nDeviceIndex);
//
//	public boolean SetDeviceBrightness(int hVideoInput, int nDeviceIndex,
//			int nBriVal);
//
//	public boolean GetDeviceBrightness(int hVideoInput, int nDeviceIndex,
//			IntByReference nBriVal, IntByReference nBriMin,
//			IntByReference nBriMax);
//
//	public boolean SetDeviceContrast(int hVideoInput, int nDeviceIndex,
//			int nConVal);
//
//	public boolean GetDeviceContrast(int hVideoInput, int nDeviceIndex,
//			IntByReference nConVal, IntByReference nConMin,
//			IntByReference nConMax);
//
//	// //////////////////////////////////////////////////////////////////////
//	// BarcodeR
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetDeviceBarcode(int hVideoInput, int nDeviceIndex,
//			boolean bBarcode);
//
//	public boolean GetDeviceBarcode(int hVideoInput, int nDeviceIndex);
//
//	public boolean SetImageFileBarcode(int hVideoInput, boolean bBarcode);
//
//	public boolean GetImageFileBarcode(int hVideoInput);
//
//	public int GetBarcodeCount(int hVideoInput);
//
//	public boolean GetBarcodeContent(int hVideoInput, int nIndex,
//			Pointer szBarcode, int nMaxSize);
//
//	public boolean GetBarcodeTypeName(int hVideoInput, int nIndex,
//			Pointer szTypeName, int nMaxSize);
//
//	// //////////////////////////////////////////////////////////////////////
//	// OCR
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetDeviceOCR(int hVideoInput, int nDeviceIndex, boolean bOCR);
//
//	public boolean GetDeviceOCR(int hVideoInput, int nDeviceIndex);
//
//	public boolean SetImageFileOCR(int hVideoInput, boolean bOCR);
//
//	public boolean GetImageFileOCR(int hVideoInput);
//
//	public boolean SetOCRLanguage(int hVideoInput, int nLanguage);
//
//	public int GetOCRLanguage(int hVideoInput);
//
//	public int GetOCRLength(int hVideoInput);
//
//	public boolean GetOCRResult(int hVideoInput, Pointer szOCR, int nMaxSize);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Undistort
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetGrabChessOnly(int hVideoInput, boolean bChessOnly);
//
//	public boolean GetGrabChessOnly(int hVideoInput);
//
//	public boolean SetChessSize(int hVideoInput, int nCols, int nRows);
//
//	public boolean GetChessSize(int hVideoInput, IntByReference pCols,
//			IntByReference pRows);
//
//	public boolean TrainChessSamples(int hVideoInput, WString szRootDir,
//			boolean bFishEyes, boolean bTangent);
//
//	public boolean SetDeviceUndistort(int hVideoInput, int nDeviceIndex,
//			boolean bUndistort);
//
//	public boolean GetDeviceUndistort(int hVideoInput, int nDeviceIndex);
//
//	public boolean SetDeviceUndistortCoeffs(int hVideoInput, int nDeviceIndex,
//			WString szCoeffs);
//
//	public boolean GetDeviceUndistortCoeffs(int hVideoInput, int nDeviceIndex,
//			Pointer szCoeffs, int nMaxSize);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Enhance
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetDeviceEnhance(int hVideoInput, int nDeviceIndex,
//			boolean enhance, int hue, int saturate, float contrast, int gain,
//			float gamma, int sharp, float sharpScale, int smooth,
//			float smoothSigma);
//
//	public boolean GetDeviceEnhance(int hVideoInput, int nDeviceIndex,
//			ByReference enhance, IntByReference hue, IntByReference saturate,
//			FloatByReference contrast, IntByReference gain,
//			FloatByReference gamma, IntByReference sharp,
//			FloatByReference sharpScale, IntByReference smooth,
//			FloatByReference smoothSigma);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Record
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetDeviceRecord(int hVideoInput, int nDeviceIndex,
//			boolean bRecord);
//
//	public boolean GetDeviceRecord(int hVideoInput, int nDeviceIndex);
//
//	public boolean SetDeviceRecordFileName(int hVideoInput, int nDeviceIndex,
//			WString szFileName);
//
//	public boolean GetDeviceRecordFileName(int hVideoInput, int nDeviceIndex,
//			Pointer szFileName, int nMaxSize);
//
//	public boolean SetDeviceRecordCodec(int hVideoInput, int nDeviceIndex,
//			WString szCodecName);
//
//	public boolean GetDeviceRecordCodec(int hVideoInput, int nDeviceIndex,
//			Pointer szCodecName, int nMaxSize);
//
//	// //////////////////////////////////////////////////////////////////////
//	// Exposure
//	// //////////////////////////////////////////////////////////////////////
//
//	public boolean SetDeviceCustomExposure(int hVideoInput, int nDeviceIndex,
//			boolean bAutoExp, int nCtrlExp, int nMinExp, int nMaxExp,
//			int nLowVal, int nHighVal);
//
//	public boolean GetDeviceCustomExposure(int hVideoInput, int nDeviceIndex,
//			ByReference bAutoExp, IntByReference nCtrlExp,
//			IntByReference nMinExp, IntByReference nMaxExp,
//			IntByReference nLowVal, IntByReference nHighVal);
//}
