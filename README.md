# YouTube Video Project

A structured repository for planning, editing, and archiving a **YouTube video project** created with **Microsoft Movie Maker**. This repository tracks your raw footage, audio assets, script revisions, and final video exports in one organized workflow.

## 🎬 Project Overview

* **Channel Name:** [Your Channel Name]
* **Video Title:** [Your Video Title Here]
* **Software Version:** Windows Movie Maker (Classic / Windows Essentials)
* **Target Platform:** YouTube (1080p Widescreen, 16:9)
* **Status:** 🎞️ In Editing

---

## 📂 Repository Structure

```text
├── assets/
│   ├── b-roll/         # Supplementary footage and overlays
│   ├── talking-head/   # Main webcam or camera recordings
│   ├── audio/          # YouTube Audio Library tracks, SFX, and voiceovers
│   └── graphics/       # Channel logos, lower thirds, and video thumbnails
├── production/
│   ├── script.md       # Video script and timestamps
│   └── project.wlmp    # Windows Movie Maker project file
├── exports/
│   └── final_upload.mp4 # Final rendered video ready for YouTube
└── README.md           # Project documentation
```

---

## 🚀 YouTube Optimization & Export Setup

To ensure your video looks crisp after YouTube's compression algorithm processes it, export using these exact settings in Movie Maker:

1. Click **File** > **Save movie**.
2. Scroll down and choose **YouTube** (or select **For high-definition display**).
3. **Recommended Settings:**
   * **Resolution:** 1920 x 1080 (1080p)
   * **Aspect Ratio:** 16:9 Widescreen
   * **Format:** MPEG-4 H.264 (.mp4)
4. Save the finalized file directly into the `exports/` folder.

---

## 📝 Upload Checklist

Before pushing this video live to YouTube, ensure the following metadata is ready to paste:

* [ ] **Thumbnail:** High-contrast 1280x720 `.png` file saved in `assets/graphics/`.
* [ ] **Title:** Under 60 characters with your primary keyword near the front.
* [ ] **Description:** First 3 lines optimized for search, followed by social links and timestamps.
* [ ] **Tags:** Relevant broad and specific focus keywords.
* [ ] **End Screen:** Standard 20-second placeholder at the end of the video timeline.

---

## 🛠️ Relinking Missing Files

Because Windows Movie Maker uses absolute file paths, sharing this folder across different computers or moving it may trigger **yellow exclamation marks** on your timeline. 

**To fix this:** Double-click any broken clip inside Movie Maker and point it to the local `assets/` subfolder inside this directory. Movie Maker will automatically relink all other missing assets in that same folder.
