package com.swlc.social_media.controller;

import com.swlc.social_media.dto.PostDTO;
import com.swlc.social_media.dto.ResponseDTO;
import com.swlc.social_media.model.PostModel;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class CreatePostController {

    public static Stage createPostStage;
    @FXML
    private ImageView imageView;
    @FXML
    private TextArea textAreaDescription;

    public File selectedImage;
    private boolean postCreated = false;

    private PostModel postModel = new PostModel();

    @FXML
    public void selectImage() {
        FileChooser fileChooser = new FileChooser();
        // Add a generic image filter for all formats
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp", "*.tiff"));

        // Open the file chooser and get the selected file
        File selectedFile = fileChooser.showOpenDialog(imageView.getScene().getWindow());
        if (selectedFile != null) {
            // Load the image into the ImageView
            Image image = new Image(selectedFile.toURI().toString());
            imageView.setImage(image);
            selectedImage = selectedFile;  // Save the selected image
        }
    }

    @FXML
    public void createPostOnAction() {
        if (selectedImage == null) {
            showAlert(new ResponseDTO("400", "Please select an image before posting.",null));
            return;
        }

        String description = textAreaDescription.getText();
        PostDTO postDTO = new PostDTO(LoginController.getLoggedChannel(), description, selectedImage.getName());
        ResponseDTO response = postModel.savePost(postDTO, selectedImage);
        showAlert(response);

        if ("200".equals(response.getStatus())) {
            postCreated = true;
            createPostStage.close();
        }
    }

    public void showAlert(ResponseDTO response) {
        Alert alert;
        if ("200".equals(response.getStatus())) {
            alert = createAlert(Alert.AlertType.CONFIRMATION, response.getMessage());
        } else {
            alert = createAlert(Alert.AlertType.ERROR, response.getMessage());
        }
        alert.show();
    }

    public Alert createAlert(Alert.AlertType alertType, String message) {
        return new Alert(alertType, message);
    }

    public boolean isPostCreated() {
        return postCreated;
    }
}
