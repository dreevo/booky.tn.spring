package tn.booky.corp.tensor.services;

public class TensorProperties {
    private String graph;
    private String label;
    private String outputDir;
    private String uploadDir;
    private Integer imageSize;
    private Float imageMean;

    public TensorProperties() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getGraph() {
        return graph;
    }

    public void setGraph(String graph) {
        this.graph = graph;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getOutputDir() {
        return outputDir;
    }

    public void setOutputDir(String outputDir) {
        this.outputDir = outputDir;
    }

    public String getUploadDir() {
        return uploadDir;
    }

    public void setUploadDir(String uploadDir) {
        this.uploadDir = uploadDir;
    }

    public Integer getImageSize() {
        return imageSize;
    }

    public void setImageSize(Integer imageSize) {
        this.imageSize = imageSize;
    }

    public Float getImageMean() {
        return imageMean;
    }

    public void setImageMean(Float imageMean) {
        this.imageMean = imageMean;
    }
}
